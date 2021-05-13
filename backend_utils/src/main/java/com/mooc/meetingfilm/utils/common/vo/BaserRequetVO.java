package com.mooc.meetingfilm.utils.common.vo;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 公共请求对象
 * @date 2021/5/719:58
 */
public abstract class BaserRequetVO {

    public abstract void checkParam() throws CommonServiceException;

}
