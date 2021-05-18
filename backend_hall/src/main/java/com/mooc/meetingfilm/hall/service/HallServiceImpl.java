package com.mooc.meetingfilm.hall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.hall.controller.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.hall.controller.vo.HallSavedReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsRespVO;
import com.mooc.meetingfilm.hall.dao.entity.MoocFieldT;
import com.mooc.meetingfilm.hall.dao.entity.MoocHallFilmInfoT;
import com.mooc.meetingfilm.hall.dao.mapper.MoocFieldTMapper;
import com.mooc.meetingfilm.hall.dao.mapper.MoocHallFilmInfoTMapper;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.util.ToolUtils;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author whc
 * @Title: HallServiceImpl
 * @Package: com.mooc.meetingfilm.hall.service
 * @Description:
 * @date 2021/5/18 20:46
 */
@Service
public class HallServiceImpl implements HallServiceAPI{

    @Resource
    private MoocFieldTMapper fieldTMapper;

    @Resource
    private MoocHallFilmInfoTMapper hallFilmInfoTMapper;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient eurekaClient;



    /**
     * @Description: 查询影厅列表
     * @Param: [hallsReqVO]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.mooc.meetingfilm.hall.controller.vo.HallsRespVO>
     * @Author: jiangzh
     */
    @Override
    public IPage<HallsRespVO> describeHalls(HallsReqVO hallsReqVO) throws CommonServiceException {

        Page<HallsReqVO> page = new Page<>(hallsReqVO.getNowPage(),hallsReqVO.getPageSize());

        QueryWrapper queryWrapper = new QueryWrapper();
        if(ToolUtils.strIsNotNull(hallsReqVO.getCinemaId())){
            queryWrapper.eq("cinema_id", hallsReqVO.getCinemaId());
        }

        IPage<HallsRespVO> result = fieldTMapper.describeHalls(page, queryWrapper);

        return result;
    }

    /**
     * @Description: 保存影厅信息
     * @Param: [hallSavedReqVO]
     * @return: void
     * @Author: jiangzh
     */
    @Override
    public void saveHall(HallSavedReqVO reqVO) throws CommonServiceException {
        // 播放厅的列表数据
        MoocFieldT field = new MoocFieldT();

        field.setCinemaId(ToolUtils.str2Int(reqVO.getCinemaId()));
        field.setFilmId(ToolUtils.str2Int(reqVO.getFilmId()));
        field.setBeginTime(reqVO.getBeginTime());
        field.setEndTime(reqVO.getEndTime());
        field.setHallId(ToolUtils.str2Int(reqVO.getHallTypeId()));
        field.setHallName(reqVO.getHallName());
        field.setPrice(ToolUtils.str2Int(reqVO.getFilmPrice()));

        fieldTMapper.insert(field);
        // 播放厅对应的影片数据， 影片冗余数据， 缓存里有一份
//        MoocHallFilmInfoT hallFilmInfo = describeFilmInfo(reqVO.getFilmId());

//        hallFilmInfoTMapper.insert(hallFilmInfo);
    }


//    // 播放厅对应的影片数据， 影片冗余数据， 缓存里有一份
//    private MoocHallFilmInfoT describeFilmInfo(String filmId) throws CommonServiceException{
//        // 解析返回值
//        BaseResponseVO<DescribeFilmRespVO> baseResponseVO = filmFeignApi.describeFilmById(filmId);
//        DescribeFilmRespVO filmResult = baseResponseVO.getData();
//        if(filmResult ==null || ToolUtils.strIsNull(filmResult.getFilmId())){
//            throw new CommonServiceException(404,"抱歉，未能找到对应的电影信息，filmId : "+filmId);
//        }
//
//        // 组织参数
//        MoocHallFilmInfoT hallFilmInfo = new MoocHallFilmInfoT();
//
//        hallFilmInfo.setFilmId(ToolUtils.str2Int(filmResult.getFilmId()));
//        hallFilmInfo.setFilmName(filmResult.getFilmName());
//        hallFilmInfo.setFilmLength(filmResult.getFilmLength());
//        hallFilmInfo.setFilmCats(filmResult.getFilmCats());
//        hallFilmInfo.setActors(filmResult.getActors());
//        hallFilmInfo.setImgAddress(filmResult.getImgAddress());
//
//        return hallFilmInfo;
//    }
}
