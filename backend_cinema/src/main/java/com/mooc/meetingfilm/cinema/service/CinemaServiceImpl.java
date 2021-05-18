package com.mooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author whc
 * @Title: CinemaServiceImpl
 * @Package: com.mooc.meetingfilm.cinema.service
 * @Description:
 * @date 2021/5/18 15:42
 */
@Data
@Service
public class CinemaServiceImpl implements CinemaServiceAPI {

    @Override
    public void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException {

    }

    @Override
    public IPage<DescribeCinemasRespVO> describeCinemas(int nowPage, int pageSize) throws CommonServiceException {
        return null;
    }


}
