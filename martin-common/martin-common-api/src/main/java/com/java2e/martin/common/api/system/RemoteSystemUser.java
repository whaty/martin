package com.java2e.martin.common.api.system;

import com.java2e.martin.common.bean.system.vo.UserRolePrivilegeVo;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/9/2
 * @describtion RemoteSystemUser, system 模块对外提供的示例服务
 * @since 1.0
 */
@FeignClient(contextId = "remoteSystemUser", name = ServiceNameConstants.MARTIN_BIZ_SYSTEM_SERVICE)
public interface RemoteSystemUser {
    /**
     * 获取用户、权限、菜单
     *
     * @param username
     * @return
     */
    @GetMapping("/user/loadUserByUsername/{username}")
    R<UserRolePrivilegeVo> loadUserByUsername(@PathVariable("username") String username);

    /**
     * 测试 post
     *
     * @param post
     * @return
     */
    @PostMapping("/sys-user/{post}/post")
    Map testPost(@PathVariable("post") String post);

    /**
     * 测试 put
     *
     * @param put
     * @return
     */
    @PutMapping("/sys-user/{put}/put")
    Map testPut(@PathVariable("put") String put);

    /**
     * 测试 delete
     *
     * @param delete
     * @return
     */
    @DeleteMapping("/sys-user/{delete}/delete")
    Map testDelete(@PathVariable("delete") String delete);

}
