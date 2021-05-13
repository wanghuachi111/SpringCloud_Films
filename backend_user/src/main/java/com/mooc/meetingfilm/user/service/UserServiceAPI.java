package com.mooc.meetingfilm.user.service;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;

/**
 * @author whc
 * @Title:
 * @Package com.mooc.meetingfilm.user.service
 * @Description: 用户接口
 * @date 2021/5/810:41
 */
public interface UserServiceAPI {

    String checkUserLogin(String username, String password) throws CommonServiceException;
}
//