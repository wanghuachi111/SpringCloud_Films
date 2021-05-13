package com.mooc.meetingfilm.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/1115:51
 */
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
