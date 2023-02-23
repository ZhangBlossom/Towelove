package com.towelove.auth.form;

/**
 * @author: 张锦标
 * @date: 2023/2/23 18:36
 * Description:
 */
public class LoginUser {
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
