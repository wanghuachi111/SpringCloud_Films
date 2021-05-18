package com.mooc.meetingfilm.hall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.hall.controller.vo.HallSavedReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsRespVO;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;

/**
 * @author whc
 * @Title: HallServiceAPI
 * @Package: com.mooc.meetingfilm.hall.service
 * @Description:
 * @date 2021/5/18 19:44
 */
public interface HallServiceAPI {

    void saveHall(HallSavedReqVO hallSavedReqVO) throws CommonServiceException;

    // 获取全部播放厅接口
    IPage<HallsRespVO> describeHalls(HallsReqVO hallsReqVO) throws CommonServiceException;

}
