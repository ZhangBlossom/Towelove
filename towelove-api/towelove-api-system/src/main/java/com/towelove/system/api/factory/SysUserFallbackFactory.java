package com.towelove.system.api.factory;

import com.towelove.common.core.domain.R;
import com.towelove.common.core.web.domain.AjaxResult;
import com.towelove.system.api.RemoteSysUserService;
import com.towelove.system.api.domain.SysUser;
import com.towelove.system.api.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author: 张锦标
 * @date: 2023/2/23 18:51
 * Description:
 */
@Component
//使用下面这个注解必须保证该类的类路径被配置到
//META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
//@AutoConfiguration
public class SysUserFallbackFactory implements FallbackFactory<RemoteSysUserService> {
    private static final Logger log = LoggerFactory.getLogger(SysUserFallbackFactory.class);

    @Override
    public RemoteSysUserService create(Throwable throwable) {
        log.error("用户登录调用失败:{}", throwable.getMessage());
        return new RemoteSysUserService() {
            @Override
            public R<LoginUser> getUserInfo(String username, String source) {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<Boolean> registerUserInfo(SysUser sysUser, String source) {
                return R.fail("注册用户失败:" + throwable.getMessage());
            }

            @Override
            public AjaxResult resetPwd(SysUser sysUser, String inner) {
                return AjaxResult.error("修改密码失败:" + throwable.getMessage());
            }

            @Override
            public R<SysUser> getUserById(Long userId) {
                return R.fail("根据ID获取用户失败:"+throwable.getMessage());
            }
        };
    }
}
