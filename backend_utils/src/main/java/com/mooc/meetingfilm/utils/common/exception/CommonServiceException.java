package com.mooc.meetingfilm.utils.common.exception;

import lombok.Data;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 公共的业务逻辑错误
 * @date 2021/5/720:05
 */
@Data
public class CommonServiceException extends Exception{

    private Integer code;
    private String message;

    public CommonServiceException (int code, String message) {
        this.code = code;
        this.message = message;
    }

}
