/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.common.utils;

import cn.gov.zjport.xlcz.common.base.BaseResult;
import cn.gov.zjport.xlcz.common.base.PageResult;
import cn.gov.zjport.xlcz.common.context.Const;
import cn.gov.zjport.xlcz.common.context.SystemContext;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;

import java.util.List;

/**
 * JSON工具类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class JSONUtil {

    /** 保存成功 */
    public static final String SAVE_SUCCESS = "保存成功";
    /** 保存失败 */
    public static final String SAVE_FAIL = "保存失败";
    /** 修改成功 */
    public static final String MODIFY_SUCCESS = "修改成功";
    /** 修改失败 */
    public static final String MODIFY_FAIL = "修改失败";

    /**
     * 返回是否成功json数据对象
     *
     * @param messageType 信息类型
     * @return String jsonstr
     */
    public static String jsonResult(String messageType) {

        String message = "成功";
        Integer code = SystemContext.CODE_SUCCESS;
        if (StringUtil.isEmpty(messageType)) {
            BaseResult baseResult = new BaseResult(code, message, null);
            return JSON.toJSONString(baseResult);
        }
        if (messageType.equals(SystemContext.MessageType.SAVE_SUCCESS.getValue())) {
            code = SystemContext.CODE_SUCCESS;
            message = SystemContext.MessageType.SAVE_SUCCESS.getTitle();
        } else if (messageType.equals(SystemContext.MessageType.SAVE_FAIL.getValue())) {
            code = SystemContext.CODE_FAIL;
            message = SystemContext.MessageType.SAVE_FAIL.getTitle();
        } else if (messageType.equals(SystemContext.MessageType.MODIFY_SUCCESS.getValue())) {
            code = SystemContext.CODE_SUCCESS;
            message = SystemContext.MessageType.MODIFY_SUCCESS.getTitle();
        } else if (messageType.equals(SystemContext.MessageType.MODIFY_FAIL.getValue())) {
            code = SystemContext.CODE_FAIL;
            message = SystemContext.MessageType.MODIFY_FAIL.getTitle();
        } else if (messageType.equals(SystemContext.MessageType.DELETE_SUCCESS.getValue())) {
            code = SystemContext.CODE_SUCCESS;
            message = SystemContext.MessageType.DELETE_SUCCESS.getTitle();
        } else if (messageType.equals(SystemContext.MessageType.DELETE_FAIL.getValue())) {
            code = SystemContext.CODE_FAIL;
            message = SystemContext.MessageType.DELETE_FAIL.getTitle();
        }

        BaseResult baseResult = new BaseResult(code, message, null);
        return JSON.toJSONString(baseResult);
    }

    /**
     * 返回是否成功json数据对象
     *
     * @param code    状态码：1成功，其他为失败
     * @param message 提示信息
     * @return String
     */
    public static String jsonResult(Integer code, String message) {
        BaseResult baseResult = new BaseResult(code, message, null);
        return JSON.toJSONString(baseResult);
    }

    /**
     * 返回是否成功json数据对象
     *
     * @param code    状态码：1成功，其他为失败
     * @param message 提示信息
     * @param list    数据
     * @return String
     */
    public static String jsonResult(Integer code, String message, List<?> list) {
        BaseResult baseResult = new BaseResult(code, message, list);
        return JSON.toJSONString(baseResult);
    }

    /**
     * 返回成功的结果集
     *
     * @param list 数据
     * @return String jsonStr
     */
    public static String succJsonResult(List<?> list) {
        BaseResult baseResult = new BaseResult(Const.CODE_SUCCESS, Const.SUCCESS_DESC, list);
        return JSON.toJSONString(baseResult);
    }

    /**
     * 返回失败的结果集
     *
     * @return String jsonStr
     */
    public static String failJsonResult() {
        BaseResult baseResult = new BaseResult(Const.CODE_FAIL, Const.FAIL_DESC, null);
        return JSON.toJSONString(baseResult);
    }

    /**
     * 返回失败的结果集
     *
     * @param msg 错误信息
     * @return String jsonStr
     */
    public static String failJsonResult(String msg) {
        BaseResult baseResult = new BaseResult(Const.CODE_FAIL, msg, null);
        return JSON.toJSONString(baseResult);
    }

    /**
     * 分页结果集转换成json字符串
     *
     * @param pageResult 分页结果集
     * @return String
     */
    public static String toJsonString(PageResult pageResult) {
        return JSON.toJSONString(pageResult);
    }

}
