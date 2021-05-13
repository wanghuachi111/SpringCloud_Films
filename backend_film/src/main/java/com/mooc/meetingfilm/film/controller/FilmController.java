package com.mooc.meetingfilm.film.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeSingleFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.FilmSavedReqVO;
import com.mooc.meetingfilm.film.service.FilmServiceAPI;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BasePageVO;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author whc
 * @Title:
 * @Package:
 * @Description: 影片模块表现层
 * @date 2021/5/12 15:49
 */
@RestController
@RequestMapping(value = "/films")
public class FilmController {

    @Autowired
    private FilmServiceAPI filmServiceAPI;



    //获取演员列表
    @GetMapping("/actors")
    public BaseResponseVO describeActors(BasePageVO basePageVO) throws CommonServiceException {

        basePageVO.checkParam();  //校验数据合法性

        IPage<DescribeActorsRespVO> results = filmServiceAPI.describeActors(basePageVO.getNowPage(), basePageVO.getPageSize());  //调用逻辑层,获取返回参数

//        return BaseResponseVO.success(describePageResult(results, "actors"));
        Map<String, Object> actors = describePageResult(results, "actors");
        return BaseResponseVO.success(actors);
    }

    //获取分页对象的公共接口
    private Map<String, Object> describePageResult(IPage page, String title) {
        Map<String, Object> result = Maps.newHashMap();

        result.put("totalSize",page.getTotal());
        result.put("totalPage",page.getPages());
        result.put("pageSize",page.getSize());
        result.put("nowPage",page.getCurrent());

        result.put(title,page.getRecords());

        return result;
    }

    //获取影片列表
    @GetMapping("")
    public BaseResponseVO describeFilms(BasePageVO basePageVO) throws CommonServiceException {

        basePageVO.checkParam();  //校验数据合法性

        IPage<DescribeFilmRespVO> results = filmServiceAPI.describeFilms(basePageVO.getNowPage(), basePageVO.getPageSize());  //调用逻辑层,获取返回参数

//        return BaseResponseVO.success(describePageResult(results, "actors"));
        Map<String, Object> films = describePageResult(results, "films");
        return BaseResponseVO.success(films);
    }

    //根据编号获取电影信息
    @GetMapping(value = "/{filmId}")
    public BaseResponseVO describeFilms(@PathVariable("filmId") String filmId) throws CommonServiceException {

        DescribeSingleFilmRespVO describeSingleFilmRespVOIPage = filmServiceAPI.describeFilmById(filmId);
        if (describeSingleFilmRespVOIPage == null) {
            return BaseResponseVO.success("No Information Found");
        }else {
            return BaseResponseVO.success(describeSingleFilmRespVOIPage);
        }
    }

    //新增影片信息
    @PostMapping(value = "/film:add")
    public BaseResponseVO saveFilmInfo(@RequestBody FilmSavedReqVO filmSavedReqVO) throws CommonServiceException {

        filmServiceAPI.saveFilm(filmSavedReqVO);

        return BaseResponseVO.success();
    }


}
