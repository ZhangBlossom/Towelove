package com.towelove.common.core.exception;

/**
 * 内部认证异常
 * 
 * @author: 张锦标
 * @date: 2023/2/23 18:46
 * Description:
 */
public class InnerAuthException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public InnerAuthException(String message)
    {
        super(message);
    }
}
