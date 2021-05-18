package com.mooc.meetingfilm.hall.controller.vo;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.vo.BasePageVO;
import com.mooc.meetingfilm.utils.common.vo.BaserRequetVO;
import lombok.Data;

/**
 * @author whc
 * @Title: HallsReqVO
 * @Package: com.mooc.meetingfilm.hall.controller.vo
 * @Description:
 * @date 2021/5/18 19:53
 */
@Data
public class HallsReqVO extends BasePageVO {    //集成BasePageVO nowPage、pageSize就有了
    private String cinemaId;

    @Override
    public void checkParam() throws CommonServiceException {
        super.checkParam();
    }
}
