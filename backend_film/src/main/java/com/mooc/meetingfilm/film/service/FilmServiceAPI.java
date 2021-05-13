package com.mooc.meetingfilm.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeSingleFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.FilmSavedReqVO;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 影片逻辑层
 * @date 2021/5/1219:18
 */
public interface FilmServiceAPI {

    //获取演员列表
    IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) throws CommonServiceException;

    //获取影片列表
    IPage<DescribeFilmRespVO> describeFilms(int nowPage, int pageSize) throws CommonServiceException;

    //根据主键获取单个影片信息
    DescribeSingleFilmRespVO describeFilmById(String filmId) throws CommonServiceException;

    //保存新增的影片信息
    void saveFilm(FilmSavedReqVO filmSavedReqVO) throws CommonServiceException;
}
