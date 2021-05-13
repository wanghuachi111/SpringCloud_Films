package com.mooc.meetingfilm.utils.common.util;

/**
 * @author whc
 * @Title:
 * @Package
 * @Description: 基础工具类
 * @date 2021/5/720:27
 */
public class ToolUtils {

    private ToolUtils() {};

    //判断字符串为空
    public static boolean strIsNull(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean strIsNull(Integer str) {
        if (str == null) {
            return true;
        } else {
            return false;
        }
    }


    //判断字符串不为空
    public static boolean strIsNotNull(String str) {
        if (strIsNull(str)) {
            return false;
        } else {
            return true;
        }
    }
}
