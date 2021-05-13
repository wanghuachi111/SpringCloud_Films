package com.mooc.meetingfilm.user.dao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.user.BackendUserApplicationTests;
import com.mooc.meetingfilm.user.dao.entity.MoocBackendUserT;
import com.mooc.meetingfilm.user.dao.mapper.MoocBackendUserTMapper;
import com.mooc.meetingfilm.utils.common.util.MD5Util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserTest extends BackendUserApplicationTests {

    @Autowired
    private MoocBackendUserTMapper backendUserT;

    /**
     * 添加后台运维用户功能
     */
    @Test
    public void add() {
        MoocBackendUserT userT = new MoocBackendUserT();

        for (int i = 1; i <= 10; i++) {
            userT.setUserName("admin" + i);
            userT.setUserPwd(MD5Util.encrypt("admin123"));
            userT.setUserPhone("1380000000" + i);
            backendUserT.insert(userT);

        }


    }

    @Test
    public void selectPage() {

        //current:当前页  size:返回的条数
        Page<MoocBackendUserT> page = new Page<>(1,10);

        QueryWrapper wrapper = new QueryWrapper();

        //模糊查询匹配admin
        wrapper.like("user_name", "admin");

        IPage<MoocBackendUserT> iPage = backendUserT.selectPage(page, wrapper);
        iPage.getRecords().stream().forEach(
                System.out::println
        );


    }

    @Test
    public void test(){

    }

}
