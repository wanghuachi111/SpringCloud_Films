package com.mooc.meetingfilm.user.controller.vo;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.util.ToolUtils;
import com.mooc.meetingfilm.utils.common.vo.BaserRequetVO;
import lombok.Data;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 登录请求对象
 * @date 2021/5/719:54
 */

@Data
public class LoginReqVO extends BaserRequetVO {

    private String username;
    private String password;


    @Override
    public void checkParam() throws CommonServiceException {
        //验证数据合法性
        if (ToolUtils.strIsNull(username) || ToolUtils.strIsNull(password)) {
            throw new CommonServiceException(404, "username or password cannot be null");
        }
    }
}
