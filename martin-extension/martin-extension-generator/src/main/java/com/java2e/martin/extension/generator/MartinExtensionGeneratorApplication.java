package com.java2e.martin.extension.generator;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/8/14
 * @describtion MartinExtensionGeneratorApplication
 * @since 1.0
 */
public class MartinExtensionGeneratorApplication {

    public static void main(String[] args) {
        codeGenerate();
//        printMenuSql();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    private static void codeGenerate() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //todo 修改输出路径
        String projectPath = "C:\\idea_project\\martin\\martin-extension\\martin-extension-generator";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(true);
        //todo 修改作者
        gc.setAuthor("狮少");
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

        //todo 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/martin?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
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

        // 包配置
        PackageConfig pc = new PackageConfig();
        //module 会生成新的模块，每个module一个目录，下面包含controller、entity、service、mapper
        pc.setModuleName("system");
        //todo 修改包名
        pc.setParent("com.java2e.martin.biz");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        String columnsPath = "/templates/ui/columns.js.vm";
        String modalPath = "/templates/ui/Modal.js.vm";
        String tablePath = "/templates/ui/Table.js.vm";
        String sqlPath = "/templates/ui/Table.sql.vm";


        // ant v4 ui 模板
        String enUsPath = "/templates/ui/locales/en-US.ts.vm";
        String zhCnPath = "/templates/ui/locales/zh-CN.ts.vm";
        String zhTwPath = "/templates/ui/locales/zh-TW.ts.vm";
        String mockPath = "/templates/ui/_mock.ts.vm";
        String indexPath = "/templates/ui/index.tsx.vm";
        String modelPath = "/templates/ui/model.ts.vm";
        String servicePath = "/templates/ui/service.ts.vm";


//
//        // 自定义输出配置
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
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(columnsPath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//
//                return projectPath + "/src/main/resources/ui/" + StrUtil.upperFirst(pc.getModuleName()) + "/" + tableInfo.getEntityName()
//                        + "/" + tableInfo.getEntityName() + "Columns.js";
//            }
//        });
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(modalPath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/ui/" + StrUtil.upperFirst(pc.getModuleName()) + "/" + tableInfo.getEntityName()
//                        + "/" + tableInfo.getEntityName() + "Modal.js";
//            }
//        });
//
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(tablePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/ui/" + StrUtil.upperFirst(pc.getModuleName()) + "/" + tableInfo.getEntityName()
//                        + "/" + "index.js";
//            }
//        });
//
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(sqlPath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return projectPath + "/src/main/resources/ui/" + StrUtil.upperFirst(pc.getModuleName()) + "Table.sql";
//            }
//        });


        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(enUsPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/locales/" + "en-US.ts";
            }
        });

        focList.add(new FileOutConfig(zhCnPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/locales/" + "zh-CN.ts";
            }
        });

        focList.add(new FileOutConfig(zhTwPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/locales/" + "zh-TW.ts";
            }
        });

        focList.add(new FileOutConfig(mockPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/" + "_mock.ts";
            }
        });

        focList.add(new FileOutConfig(indexPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/" + "index.tsx";
            }
        });

        focList.add(new FileOutConfig(modelPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/" + "model.ts";
            }
        });

        focList.add(new FileOutConfig(servicePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/ui/" + pc.getModuleName() + "/" + tableInfo.getEntityName().toLowerCase()
                        + "/" + "service.ts";
            }
        });

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        templateConfig.setController("templates/controller.java");

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setTablePrefix("sys_");
        strategy.setEntitySerialVersionUID(true);
        strategy.setLogicDeleteFieldName("del_flag");
        // 公共父类
        strategy.setSuperControllerClass("");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("");
        //todo 修改要生成的表名，多个英文逗号分割
//        String[] tables = {"sys_dept", "sys_dept_role", "sys_dept_user", "sys_dict", "sys_element", "sys_file", "sys_log", "sys_menu", "sys_operation", "sys_privilege", "sys_role", "sys_role_privilege", "sys_social_details", "sys_user", "sys_user_role"};
        String[] tables = {"sys_config"};
        strategy.setInclude(tables);
        System.out.println("========menuSql========");
        printMenuSql(tables);
        System.out.println("========================");
        System.out.println("========operateSql======");
        printOperateSql(tables);
        System.out.println("========================");
//        strategy.setInclude("sys_menu");
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("creator", FieldFill.INSERT));
        tableFills.add(new TableFill("updater", FieldFill.UPDATE));
        tableFills.add(new TableFill("update_time", FieldFill.UPDATE));
        strategy.setTableFillList(tableFills);
        mpg.execute();
    }

    private static void printOperateSql(String[] tables) {
        if (tables.length <= 0) {
            return;
        }
        String sql = "INSERT INTO sys_operation ( name, authority,parent_id) VALUES ('{}', '{}','0');";
        Arrays.asList(tables).stream().forEach(s -> {
            String[] operate = {"add", "del", "edit", "get", "page", "deleteBatch"};
            Arrays.asList(operate).forEach(s1 -> System.out.println(StrUtil.format(sql, s + "_" + s1, s + "_" + s1)));
        });
    }

    public static void printMenuSql(String[] tables) {
//        String[] tables = {"sys_dept", "sys_dept_role", "sys_dept_user", "sys_dict", "sys_element", "sys_file", "sys_log", "sys_menu", "sys_operation", "sys_privilege", "sys_role", "sys_role_privilege", "sys_social_details", "sys_user", "sys_user_role"};
        if (tables.length <= 0) {
            return;
        }
        String childSql = "INSERT INTO sys_menu ( name, authority, path,component, sort) VALUES ( '{}', '{}', '{}', './System/{}/index',1);";
        String parentSql = "INSERT INTO sys_menu ( name, authority, path) VALUES ( '{}', '{}', '{}');";
        System.out.println(StrUtil.format(parentSql, "system", "system", "/system"));
        Arrays.asList(tables).stream()
                .map(s -> StrUtil.format(childSql, getSysCamel(s, "sys_"), "system-" + getSysAuth(s, "sys_"), "/system/" + getSysUrl(s, "sys_"), StrUtil.upperFirst(getSysCamel(s, "sys_"))))
                .forEach(s -> System.out.println(s));
    }

    private static String getSys(String s, String sys_) {
        return StrUtil.subAfter(s, sys_, true);
    }

    private static String getSysCamel(String s, String sys_) {
        return StrUtil.toCamelCase(getSys(s, sys_));
    }

    private static String getSysAuth(String s, String sys_) {
        return StrUtil.subAfter(s, sys_, true).replace("_", "-");
    }

    private static String getSysUrl(String s, String sys_) {
        return StrUtil.subAfter(s, sys_, true).replace("_", "");
    }

}
