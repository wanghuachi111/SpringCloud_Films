package com.mooc.meetingfilm.film.controller.vo;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BaserRequetVO;
import lombok.Data;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 新增or保存电影信息对象
 * @date 2021/5/1310:57
 */
@Data
public class FilmSavedReqVO extends BaserRequetVO {

    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String mainImgAddress;
    private String filmScore;
    private String filmScorers;
    private String preSaleNum;
    private String boxOffice;
    private String filmTypeId;
    private String filmSourceId;
    private String filmCatIds;
    private String areaId;
    private String dateId;
    private String filmTime;
    private String directorId;
    private String actIds;      // actIds与RoleNames是不是能在数量上对应上
    private String roleNames;
    private String filmLength;
    private String biography;
    private String filmImgs;


    @Override
    public void checkParam() throws CommonServiceException {

    }
}
