package com.mooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BasePageVO;
import org.springframework.stereotype.Service;

/**
 * @author whc
 * @Title: CinemaServiceAPI
 * @Package: com.mooc.meetingfilm.cinema.service
 * @Description:
 * @date 2021/5/18 15:40
 */

public interface CinemaServiceAPI {

    //保存or新增影院
    void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException;

    //查询影院
    IPage<DescribeCinemasRespVO> describeCinemas(int nowPage, int pageSize) throws CommonServiceException;
}
