package com.mooc.meetingfilm.cinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.cinema.service.CinemaServiceAPI;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BasePageVO;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author whc
 * @Title: cinemaController
 * @Package: com.mooc.meetingfilm.cinema.controller.vo
 * @Description: 影院模块表现层
 * @date 2021/5/18 14:58
 */
@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaServiceAPI cinemaServiceAPI;


    @PostMapping("/cinema:add")
    public BaseResponseVO saveCinema(@RequestBody CinemaSavedReqVO cinemaSavedReqVO) throws CommonServiceException {

        //数据验证
        cinemaSavedReqVO.checkParam();

        cinemaServiceAPI.saveCinema(cinemaSavedReqVO);

        return BaseResponseVO.success();
    }

    @GetMapping("")
    public BaseResponseVO describeCinemas(BasePageVO basePageVO) throws CommonServiceException {

        IPage<DescribeCinemasRespVO> result = cinemaServiceAPI.describeCinemas(basePageVO.getNowPage(), basePageVO.getPageSize());

        Map<String, Object> cinemas = describePageResult(result, "cinemas");

        return BaseResponseVO.success(cinemas);
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

}
