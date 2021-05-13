package com.mooc.meetingfilm.utils.common.vo;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import lombok.Data;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 表现层公共返回
 * @date 2021/5/516:51
 */
@Data
public class BaseResponseVO<M> {

    private Integer code;
    private String message;
    private M data;   //业务数据返回

    private BaseResponseVO() {};

    //成功但无参数
    public static BaseResponseVO success () {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");

        return response;
    }

    //成功有参数
    public static<M> BaseResponseVO success(M data) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        response.setData(data);

        return response;
    }

    //成功有参数
    public static<M> BaseResponseVO success(String message) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage(message);
        return response;
    }

    //出现业务异常
    public static<M> BaseResponseVO serviceException(CommonServiceException e) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

}
