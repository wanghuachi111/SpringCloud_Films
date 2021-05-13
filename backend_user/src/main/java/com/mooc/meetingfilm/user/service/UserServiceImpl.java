package com.mooc.meetingfilm.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.mooc.meetingfilm.user.dao.entity.MoocBackendUserT;
import com.mooc.meetingfilm.user.dao.mapper.MoocBackendUserTMapper;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 用户模块业务实现
 * @date 2021/5/810:43
 */

@Service
public class UserServiceImpl implements UserServiceAPI {

    @Autowired
    private MoocBackendUserTMapper userTMapper;

    @Override
    public String checkUserLogin(String username, String password) throws CommonServiceException {
        //根据用户民获取用户信息
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", username);
        List<MoocBackendUserT> list = userTMapper.selectList(queryWrapper);

        MoocBackendUserT user = null;
        if (list != null && list.size() > 0) {     //方便测试，避免数据出现问题
            user = list.stream().findFirst().get();
        }else {
            throw new CommonServiceException(404,"error username");
        }

        //验证密码是否正确【密码要做MD5加密。才能验证是否匹配】
        String encrypt = MD5Util.encrypt(password);
        if (!encrypt.equals(user.getUserPwd())) {
            throw new CommonServiceException(500, "error password");
        }else {
            return user.getUuid()+"";
        }

    }
}
