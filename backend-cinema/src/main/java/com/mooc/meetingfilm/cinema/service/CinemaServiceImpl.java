package com.mooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.cinema.dao.entity.MoocCinemaT;
import com.mooc.meetingfilm.cinema.dao.mapper.MoocCinemaTMapper;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.util.ToolUtils;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author whc
 * @Title: CinemaServiceImpl
 * @Package: com.mooc.meetingfilm.cinema.service
 * @Description:
 * @date 2021/6/3 23:04
 */

@Data
@Service
public class CinemaServiceImpl implements CinemaServiceAPI{

    @Resource
    private MoocCinemaTMapper cinemaTMapper;


    @Override
    public void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException {

        MoocCinemaT moocCinemaT = new MoocCinemaT();

        moocCinemaT.setCinemaName(reqVO.getCinemaName());
        moocCinemaT.setCinemaPhone(reqVO.getCinemaTele());
        moocCinemaT.setBrandId(ToolUtils.str2Int(reqVO.getBrandId()));
        moocCinemaT.setAreaId(ToolUtils.str2Int(reqVO.getAreaId()));
        moocCinemaT.setHallIds(reqVO.getHallTypeIds());
        moocCinemaT.setImgAddress(reqVO.getCinemaImgAddress());
        moocCinemaT.setCinemaAddress(reqVO.getCinemaAddress());
        moocCinemaT.setMinimumPrice(ToolUtils.str2Int(reqVO.getCinemaPrice()));

        cinemaTMapper.insert(moocCinemaT);
    }

    @Override
    public IPage<DescribeCinemasRespVO> describeCinemas(int nowPage, int pageSize) throws CommonServiceException {

        // 查询实体对象，然后与表现层对象进行交互
        Page<MoocCinemaT> page = new Page<>(nowPage, pageSize);
        IPage<MoocCinemaT> moocCinemaTIPage = cinemaTMapper.selectPage(page, null);

        // moocCinemaTIPage对象内的分页参数与IPage<DescribeCinemasRespVO>一模一样

        IPage<DescribeCinemasRespVO> respVOIPage = new Page<>();
        List<DescribeCinemasRespVO> respVOS = new ArrayList<>();
        List<MoocCinemaT> records = moocCinemaTIPage.getRecords();// set到IPage<DescribeCinemasRespVO> records方法中
        for (MoocCinemaT a : records) {
            DescribeCinemasRespVO b = new DescribeCinemasRespVO();
            b.setCinemaAddress(a.getCinemaAddress());
            b.setCinemaName(a.getCinemaName());
            b.setCinemaPrice(a.getMinimumPrice().toString());
            b.setCinemaTele(a.getCinemaPhone());
            b.setAreaId(a.getAreaId().toString());
            b.setBrandId(a.getBrandId().toString());
            b.setCinemaImgAddress(a.getImgAddress());
            b.setHallTypeIds(a.getHallIds());
            respVOS.add(b);
        }

        respVOIPage.setRecords(respVOS);

        return respVOIPage;
    }
}
