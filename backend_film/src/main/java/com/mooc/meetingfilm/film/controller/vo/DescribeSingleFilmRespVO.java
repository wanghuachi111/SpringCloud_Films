package com.mooc.meetingfilm.film.controller.vo;

import lombok.Data;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 根据主键获取单个影片信息
 * @date 2021/5/1221:31
 */
@Data
public class DescribeSingleFilmRespVO {


    private String filmId;
    private String filmNamep;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private String subAddress;

}
