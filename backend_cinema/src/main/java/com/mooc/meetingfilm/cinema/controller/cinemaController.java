package com.mooc.meetingfilm.cinema.controller;

import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whc
 * @Title: cinemaController
 * @Package: com.mooc.meetingfilm.cinema.controller.vo
 * @Description: 影院模块表现层
 * @date 2021/5/18 14:58
 */
@RestController
@RequestMapping("/cinemas")
public class cinemaController {

    @PostMapping("/cinema:add")
    public BaseResponseVO saveCinema() {

        return BaseResponseVO.success();
    }

    @GetMapping
    public BaseResponseVO describeCinemas() {

        return BaseResponseVO.success();
    }

}
