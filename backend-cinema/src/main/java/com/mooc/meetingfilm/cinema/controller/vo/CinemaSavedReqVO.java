package com.mooc.meetingfilm.cinema.controller.vo;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BaserRequetVO;
import lombok.Data;

/**
 * @author whc
 * @Title: cinemaSavedReqVO
 * @Package: com.mooc.meetingfilm.cinema.controller.vo
 * @Description: 新增影院对象VO
 * @date 2021/5/18 15:36
 */
@Data
public class CinemaSavedReqVO extends BaserRequetVO {


    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;

    @Override
    public void checkParam() throws CommonServiceException {
        //验证数据合法性
    }
}
