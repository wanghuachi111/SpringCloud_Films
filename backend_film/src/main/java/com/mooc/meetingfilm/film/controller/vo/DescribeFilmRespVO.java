package com.mooc.meetingfilm.film.controller.vo;

import lombok.Data;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 查询影片列表返回对象VO
 * @date 2021/5/1220:53
 */
@Data
public class DescribeFilmRespVO {

    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String filmScore;
    private String preSaleNum;
    private String boxOffice;
    private String filmTime;
    private String filmLength;
    private String mainImg;

}
