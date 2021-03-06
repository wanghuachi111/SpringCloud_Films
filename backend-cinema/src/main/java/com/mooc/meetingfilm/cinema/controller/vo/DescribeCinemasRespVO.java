package com.mooc.meetingfilm.cinema.controller.vo;

import lombok.Data;

/**
 * @author whc
 * @Title: DescribeCinemasRespVO
 * @Package: com.mooc.meetingfilm.cinema.controller.vo
 * @Description:
 * @date 2021/6/3 23:01
 */

@Data
public class DescribeCinemasRespVO {

    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;

}
