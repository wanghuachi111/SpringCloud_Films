package com.mooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;

public interface CinemaServiceAPI {

    //保存or新增影片
    void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException;

    //查询影片
    IPage<DescribeCinemasRespVO> describeCinemas(int nowPage, int pageSize) throws CommonServiceException;
}
