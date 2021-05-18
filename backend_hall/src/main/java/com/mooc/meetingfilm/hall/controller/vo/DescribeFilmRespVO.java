package com.mooc.meetingfilm.hall.controller.vo;

import lombok.Data;

/**
 * @author whc
 * @Title: DescribeHallReqVO
 * @Package: com.mooc.meetingfilm.hall.controller.vo
 * @Description: 根据主键获取影片信息对象,  用作Eureka调用测试----调用film微服务中方法
 * @date 2021/5/18 19:47
 */
@Data
public class DescribeFilmRespVO {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private String subAddress;

}
