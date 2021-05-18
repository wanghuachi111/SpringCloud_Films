package com.mooc.meetingfilm.hall.controller.vo;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BaserRequetVO;
import lombok.Data;

/**
 * @author whc
 * @Title: HallSavedReqVO
 * @Package: com.mooc.meetingfilm.hall.controller.vo
 * @Description:
 * @date 2021/5/18 19:45
 */
@Data
public class HallSavedReqVO extends BaserRequetVO {

    private String cinemaId;
    private String filmId;
    private String hallTypeId;
    private String beginTime;
    private String endTime;
    private String filmPrice;
    private String hallName;


    @Override
    public void checkParam() throws CommonServiceException {

    }
}
