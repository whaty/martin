package com.java2e.martin.extension.generator.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.CommonConstants;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import com.java2e.martin.common.security.util.SecurityContextUtil;
import com.java2e.martin.extension.generator.entity.Code;
import com.java2e.martin.extension.generator.mapper.CodeMapper;
import com.java2e.martin.extension.generator.service.CodeService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 系统代码生成表 服务实现类
 * </p>
 *
 * @author 狮少
 * @version 1.0
 * @date 2020-09-14
 * @describtion
 * @since 1.0
 */
@Service
public class CodeServiceImpl extends MartinServiceImpl<CodeMapper, Code> implements CodeService {
    @Override
    protected void setEntity() {
        this.clz = Code.class;
    }

    @Override
    public R generateCode(Code code, HttpServletResponse response) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        String pathName = SecurityContextUtil.getUser().getUsername() + IdUtil.simpleUUID();
        String projectPath = System.getProperty("user.dir") + File.separator + pathName;
        System.out.println("projectPath = " + projectPath);
        // 全局配置
        setGlobalConfig(projectPath, code, mpg);
        //数据源设置
        setDataSource(mpg, code);
        // 包配置
        PackageConfig pc = setPackageConfig(code, mpg);
        // 自定义配置
        setInjectionConfig(mpg, projectPath, pc, code);
        // 配置模板
        setTemplateConfig(mpg);
        // 策略配置
        setStrategyConfig(code, mpg);
        mpg.execute();
        ZipUtil.zip(projectPath);
        File file = new File(projectPath + ".zip");
        response.setHeader("content-type", "image/png");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + pathName + ".zip");
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int read = bis.read(buff);
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return R.failed("下载失败");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        FileUtil.del(file);
        FileUtil.del(projectPath);
        return R.ok("下载成功");
    }

    private void setStrategyConfig(Code code, AutoGenerator mpg) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("");
        strategy.setSuperServiceClass("MartinService");
        strategy.setSuperServiceImplClass("MartinServiceImpl");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        if (StrUtil.isNotBlank(code.getTablePrefix())) {
            strategy.setTablePrefix(code.getTablePrefix());
        }
        strategy.setEntitySerialVersionUID(true);
        strategy.setLogicDeleteFieldName("del_flag");
        // 公共父类
        strategy.setSuperControllerClass("");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("");
        String[] tables = {code.getTableName()};
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill(CommonConstants.CREATOR, FieldFill.INSERT));
        tableFills.add(new TableFill(CommonConstants.CREATE_TIME, FieldFill.INSERT));
        tableFills.add(new TableFill(CommonConstants.UPDATER, FieldFill.UPDATE));
        tableFills.add(new TableFill(CommonConstants.UPDATE_TIME, FieldFill.UPDATE));
        strategy.setTableFillList(tableFills);
        mpg.setStrategy(strategy);
    }

    private void setTemplateConfig(AutoGenerator mpg) {
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        templateConfig.setController("templates/controller.java");
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
    }

    private void setInjectionConfig(AutoGenerator mpg, String projectPath, PackageConfig pc, Code code) {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                HashMap<String, Object> map = new HashMap<>();
                map.put("moduleName", code.getModuleName());
                setMap(map);
            }
        };
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // ant v4 ui 模板
        String enUsPath = "/templates/ui/locales/en-US.ts.vm";
        String zhCnPath = "/templates/ui/locales/zh-CN.ts.vm";
        String zhTwPath = "/templates/ui/locales/zh-TW.ts.vm";
        String mockPath = "/templates/ui/_mock.ts.vm";
        String indexPath = "/templates/ui/index.tsx.vm";
        String modelPath = "/templates/ui/model.ts.vm";
        String servicePath = "/templates/ui/service.ts.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(enUsPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/locales/" + "en-US.ts";
            }
        });
        focList.add(new FileOutConfig(zhCnPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/locales/" + "zh-CN.ts";
            }
        });
        focList.add(new FileOutConfig(zhTwPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/locales/" + "zh-TW.ts";
            }
        });
        focList.add(new FileOutConfig(mockPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/" + "_mock.ts";
            }
        });
        focList.add(new FileOutConfig(indexPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/" + "index.tsx";
            }
        });
        focList.add(new FileOutConfig(modelPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/" + "model.ts";
            }
        });
        focList.add(new FileOutConfig(servicePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/" + "service.ts";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }

    private PackageConfig setPackageConfig(Code code, AutoGenerator mpg) {
        PackageConfig pc = new PackageConfig();
        //module 会生成新的模块，每个module一个目录，下面包含controller、entity、service、mapper
        pc.setModuleName(code.getModuleName());
        pc.setParent(code.getParent());
        mpg.setPackageInfo(pc);
        return pc;
    }

    private void setDataSource(AutoGenerator mpg, Code code) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(code.getDbUrl());
        dsc.setDriverName(code.getDbDriverName());
        dsc.setUsername(code.getDbUsername());
        dsc.setPassword(code.getDbPassword());
        dsc.setDbQuery(
                new MySqlQuery() {
                    /**
                     * 重写父类预留查询自定义字段<br>
                     * 这里查询的 SQL 对应父类 tableFieldsSql 的查询字段，默认不能满足你的需求请重写它<br>
                     * 模板中调用：  table.fields 获取所有字段信息，
                     * 然后循环字段获取 field.customMap 从 MAP 中获取注入字段如下  NULL 或者 PRIVILEGES
                     */
                    @Override
                    public String[] fieldCustom() {
                        return new String[]{"NULL", "PRIVILEGES"};
                    }
                }
        );
        mpg.setDataSource(dsc);
    }

    private void setGlobalConfig(String projectPath, Code code, AutoGenerator mpg) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(true);
        gc.setAuthor(code.getAuthor());
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);
    }
}
