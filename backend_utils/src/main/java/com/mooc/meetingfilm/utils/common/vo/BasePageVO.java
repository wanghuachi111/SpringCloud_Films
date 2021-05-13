package com.mooc.meetingfilm.utils.common.vo;

import com.mooc.meetingfilm.utils.common.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.common.util.ToolUtils;
import lombok.Data;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 分页请求类
 * @date 2021/5/1215:55
 */
@Data
public class BasePageVO extends BaserRequetVO{

    private Integer nowPage = 1;
    private Integer pageSize = 10;


    @Override
    public void checkParam() throws CommonServiceException {
        //验证数据合法性
        if (ToolUtils.strIsNull(nowPage) || ToolUtils.strIsNull(pageSize)) {
            throw new CommonServiceException(404, "nowPage or pageSize cannot be null");
        }
    }
}
