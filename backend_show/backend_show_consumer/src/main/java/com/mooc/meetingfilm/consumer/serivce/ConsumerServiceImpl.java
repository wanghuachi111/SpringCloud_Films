package com.mooc.meetingfilm.consumer.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/1115:47
 */
@Service
public class ConsumerServiceImpl implements ConsumerServiceAPI {


    @Autowired
    private LoadBalancerClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String sayHello(String message) {


        ServiceInstance choose = eurekaClient.choose("hello-service-provider");

        //动态获取hostname和port
        String hostname = choose.getHost();
        int port = choose.getPort();
        String uri = "/provider/sayhello?message=" + message;
        String url = "http://" + hostname + ":" + port + uri;

        //invoker provider test
        String result = restTemplate.getForObject(url, String.class);



        return result;
    }
}
