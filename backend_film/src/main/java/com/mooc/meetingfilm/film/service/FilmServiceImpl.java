package com.mooc.meetingfilm.film.service;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeSingleFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.FilmSavedReqVO;
import com.mooc.meetingfilm.film.dao.entity.MoocActorT;
import com.mooc.meetingfilm.film.dao.entity.MoocFilmActorT;
import com.mooc.meetingfilm.film.dao.entity.MoocFilmInfoT;
import com.mooc.meetingfilm.film.dao.entity.MoocFilmT;
import com.mooc.meetingfilm.film.dao.mapper.MoocActorTMapper;
import com.mooc.meetingfilm.film.dao.mapper.MoocFilmActorTMapper;
import com.mooc.meetingfilm.film.dao.mapper.MoocFilmInfoTMapper;
import com.mooc.meetingfilm.film.dao.mapper.MoocFilmTMapper;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.util.ToolUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 影片模块实现层
 * @date 2021/5/1219:18
 */
@Data
@Service
public class FilmServiceImpl implements FilmServiceAPI {

    @Resource
    //@Autowired 也可，但是会有bug报错，不影响运行
    private MoocActorTMapper actorTMapper;

    @Resource
    private MoocFilmActorTMapper filmActorTMapper;

    @Resource
    private MoocFilmInfoTMapper filmInfoTMapper;

    @Resource
    private MoocFilmTMapper filmTMapper;


    /**
     * @Description: 演员查询列表
     * @Param: [nowPage, pageSize]
     * @return:
     * @Author: whc
     */
    @Override
    public IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) throws CommonServiceException {

        return actorTMapper.describeActors(new Page<>(nowPage, pageSize));
    }


    /**
     * @Description: 影片列表查询
     * @Param: [nowPage, pageSize]
     * @return:
     * @Author: whc
     */
    @Override
    public IPage<DescribeFilmRespVO> describeFilms(int nowPage, int pageSize) throws CommonServiceException {

        return filmTMapper.describeFilms(new Page<>(nowPage, pageSize));
    }



    /**
     * @Description: 根据主键Id获取电影详情
     * @Param: [filmId]
     * 最复杂的场景，sql语句极其繁杂
     * @Author: whc
     */
    @Override
    public DescribeSingleFilmRespVO describeFilmById(String filmId) throws CommonServiceException {

        return filmTMapper.describeFilmById(filmId);
    }


    /**
     * @Description: 保存电影信息
     * @Param: [filmSavedReqVO]
     * @return: void
     * @Author: whc
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveFilm(FilmSavedReqVO filmSavedReqVO) throws CommonServiceException {
        try {
            //保存电影主表
            MoocFilmT filmT = new MoocFilmT();
            filmT.setFilmName(filmSavedReqVO.getFilmName());
            filmT.setFilmType(ToolUtils.str2Int(filmSavedReqVO.getFilmTypeId()));
            filmT.setImgAddress(filmSavedReqVO.getMainImgAddress());
            filmT.setFilmScore(filmSavedReqVO.getFilmScore());
            filmT.setFilmPresalenum(ToolUtils.str2Int(filmSavedReqVO.getPreSaleNum()));
            filmT.setFilmBoxOffice(ToolUtils.str2Int(filmSavedReqVO.getBoxOffice()));
            filmT.setFilmSource(ToolUtils.str2Int(filmSavedReqVO.getFilmSourceId()));
            filmT.setFilmCats(filmSavedReqVO.getFilmCatIds());
            filmT.setFilmArea(ToolUtils.str2Int(filmSavedReqVO.getAreaId()));
            filmT.setFilmDate(ToolUtils.str2Int(filmSavedReqVO.getDateId()));
            filmT.setFilmTime(ToolUtils.str2LocalDateTime(filmSavedReqVO.getFilmTime() + " 00:00:00"));
            filmT.setFilmStatus(ToolUtils.str2Int(filmSavedReqVO.getFilmStatus()));

            filmTMapper.insert(filmT);

            //保存电影子表
            MoocFilmInfoT filmInfoT = new MoocFilmInfoT();
            filmInfoT.setFilmId(filmT.getUuid() + "");
            filmInfoT.setFilmEnName(filmSavedReqVO.getFilmEnName());
            filmInfoT.setFilmScore(filmSavedReqVO.getFilmScore());
            filmInfoT.setFilmScoreNum(ToolUtils.str2Int(filmSavedReqVO.getFilmScorers()));
            filmInfoT.setFilmLength(ToolUtils.str2Int(filmSavedReqVO.getFilmLength()));
            filmInfoT.setBiography(filmSavedReqVO.getBiography());
            filmInfoT.setDirectorId(ToolUtils.str2Int(filmSavedReqVO.getDirectorId()));
            filmInfoT.setFilmImgs(filmSavedReqVO.getFilmImgs());

            filmInfoTMapper.insert(filmInfoT);

            String[] actorId = filmSavedReqVO.getActIds().split("#");
            String[] roleNames = filmSavedReqVO.getRoleNames().split("#");
            if (actorId.length != roleNames.length) {
                throw new CommonServiceException(500, "演员和角色名数量不匹配");
            }

            for (int i = 0; i < actorId.length; i++) {
                //保存演员映射表
                MoocFilmActorT filmActorT = new MoocFilmActorT();
                filmActorT.setFilmId(filmT.getUuid());
                filmActorT.setActorId(ToolUtils.str2Int(actorId[i]));
                filmActorT.setRoleName(roleNames[i]);
                filmActorTMapper.insert(filmActorT);
            }



        } catch (Exception e) {
            throw new CommonServiceException(500, e.getMessage());
        }
    }


}
