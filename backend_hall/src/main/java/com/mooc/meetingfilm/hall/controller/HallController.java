package com.mooc.meetingfilm.hall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.mooc.meetingfilm.hall.controller.vo.HallSavedReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsRespVO;
import com.mooc.meetingfilm.hall.service.HallServiceAPI;
import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author whc
 * @Title: HallController
 * @Package: com.mooc.meetingfilm.hall.controller
 * @Description:
 * @date 2021/5/18 19:46
 */
@RestController
@RequestMapping("/halls")
public class HallController {


    @Resource
    private HallServiceAPI hallServiceAPI;

    /**
     * @Description: 新增播放厅
     * @Param: [hallsReqVO]
     * @return: com.mooc.meetingfilm.utils.common.vo.BaseResponseVO
     * @Author: jiangzh
     */
    @RequestMapping(value = "/hall:add",method = RequestMethod.POST)
    public BaseResponseVO saveHall(@RequestBody HallSavedReqVO hallSavedReqVO) throws CommonServiceException {

        hallSavedReqVO.checkParam();

        hallServiceAPI.saveHall(hallSavedReqVO);

        return BaseResponseVO.success();
    }


    // 获取分页对象的公共接口
    private Map<String,Object> descrbePageResult(IPage page, String title){
        Map<String,Object> result = Maps.newHashMap();

        result.put("totalSize",page.getTotal());
        result.put("totalPages",page.getPages());
        result.put("pageSize",page.getSize());
        result.put("nowPage",page.getCurrent());

        result.put(title, page.getRecords());

        return result;
    }


    /**
     * @Description: 获取播放厅列表
     * @Param: [hallsReqVO]
     * @return: com.mooc.meetingfilm.utils.common.vo.BaseResponseVO
     * @Author: jiangzh
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public BaseResponseVO describeHalls(HallsReqVO hallsReqVO) throws CommonServiceException {

        hallsReqVO.checkParam();

        IPage<HallsRespVO> page = hallServiceAPI.describeHalls(hallsReqVO);

        Map<String, Object> halls = descrbePageResult(page, "halls");

        return BaseResponseVO.success(halls);
    }
}
