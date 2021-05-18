package com.mooc.meetingfilm.cinema.controller;

import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.service.CinemaServiceAPI;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BasePageVO;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        cinemaServiceAPI.describeCinemas(basePageVO.getNowPage(), basePageVO.getPageSize());

        return BaseResponseVO.success();
    }

}
