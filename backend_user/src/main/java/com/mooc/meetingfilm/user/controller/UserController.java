package com.mooc.meetingfilm.user.controller;

import com.mooc.meetingfilm.user.controller.vo.LoginReqVO;
import com.mooc.meetingfilm.user.service.UserServiceAPI;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.util.JwtTokenUtil;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 用户模块表现层
 * @date 2021/5/719:42
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceAPI serviceAPI;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponseVO login(@RequestBody LoginReqVO reqVO) throws CommonServiceException {

        //数据验证,若数据不合法则会抛出异常，下面的代码则不会执行
        reqVO.checkParam();
        //验证用户名密码是否正确
        String userId = serviceAPI.checkUserLogin(reqVO.getUsername(), reqVO.getPassword());

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomKey = jwtTokenUtil.getRandomKey();
        String token = jwtTokenUtil.generateToken(userId, randomKey);

        //randomkey,token
        Map<String, String> result = new HashMap<>();
        result.put("randomKey", randomKey);
        result.put("token", token);

        return BaseResponseVO.success(result);
    }

}
