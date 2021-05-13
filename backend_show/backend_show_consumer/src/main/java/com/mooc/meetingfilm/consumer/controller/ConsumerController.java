package com.mooc.meetingfilm.consumer.controller;

import com.mooc.meetingfilm.consumer.serivce.ConsumerServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/1115:48
 */

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerServiceAPI serviceAPI;

    @RequestMapping("/sayhello")
    public String sayHello(String message) {

        return serviceAPI.sayHello(message);
    }
}
