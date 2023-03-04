package com.towelove.system.api;

import com.towelove.common.core.constant.SecurityConstants;
import com.towelove.common.core.constant.ServiceNameConstants;
import com.towelove.common.core.domain.R;
import com.towelove.system.api.factory.RemoteUserFallbackFactory;
import com.towelove.system.api.domain.SysUser;
import com.towelove.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 张锦标
 * @date: 2023/2/23 18:51
 * Description:
 */
@FeignClient(contextId = "remoteUserService",
        value = ServiceNameConstants.SYSTEM_SERVICE,
        fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService
{
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @GetMapping("/sys/user/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username,
                                    @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 注册用户信息
     *
     * @param sysUser 用户信息
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/sys/user/register")
    public R<Boolean> registerUserInfo(@RequestBody SysUser sysUser,
                                       @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
