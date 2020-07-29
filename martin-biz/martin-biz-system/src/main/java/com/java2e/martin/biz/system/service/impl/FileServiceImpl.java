package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.File;
import com.java2e.martin.biz.system.mapper.FileMapper;
import com.java2e.martin.biz.system.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统操作 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

}
