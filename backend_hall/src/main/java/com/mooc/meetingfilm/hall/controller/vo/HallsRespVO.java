package com.mooc.meetingfilm.hall.controller.vo;

import lombok.Data;

/**
 * @author whc
 * @Title: HallsRespVO
 * @Package: com.mooc.meetingfilm.hall.controller.vo
 * @Description:
 * @date 2021/5/18 19:51
 */
@Data
public class HallsRespVO {

    private String cinemaName;
    private String hallName;
    private String filmName;
    private String hallTypeName;
    private String beginTime;
    private String endTime;
    private String filmPrice;

}
