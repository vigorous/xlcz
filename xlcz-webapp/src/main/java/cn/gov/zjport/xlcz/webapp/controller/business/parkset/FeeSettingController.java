/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.business.parkset;

import cn.gov.zjport.xlcz.common.base.PageResult;
import cn.gov.zjport.xlcz.common.context.SystemContext;
import cn.gov.zjport.xlcz.common.utils.JSONUtil;
import cn.gov.zjport.xlcz.common.utils.PageUtil;
import cn.gov.zjport.xlcz.domain.vo.FeeSetting;
import cn.gov.zjport.xlcz.service.business.FeeSettingService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 费率设置管理
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/feesetting")
public class FeeSettingController extends BaseController {
    /** serialVersionUID */
    private static final long serialVersionUID = 7359285576455668791L;

    /** 路劲前缀 */
    private static final String PREFIX = "business/parkset/feesetting/";

    /** 费率设置服务 */
    @Autowired
    private FeeSettingService feeSettingService;

    /**
     * 费率设置列表页面
     *
     * @return String
     */
    @RequestMapping(value = "/index")
    public String index() {
        return PREFIX + "feesetting_list";
    }

    /**
     * 费率设置列表
     *
     * @return Object
     */
    @RequestMapping(value = "/feeSettingList")
    @ResponseBody
    public Object feeSettingList() {
        List<FeeSetting> list = feeSettingService.findAll();
        PageInfo<FeeSetting> pageInfo = new PageInfo<>(list);
        PageResult pageResult = PageUtil.getPageResult(pageInfo);
        return JSON.toJSONString(pageResult);
    }

    /**
     * 修改费率
     *
     * @param feeSettingJson
     * @return Object
     */
    @RequestMapping(value = "/updateFeeSettings")
    @ResponseBody
    public Object updateFeeSettings(String feeSettingJson) {
        try {
            List<FeeSetting> list = JSON.parseArray(feeSettingJson, FeeSetting.class);
            feeSettingService.updateFeeSettings(list);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return JSONUtil.jsonResult(SystemContext.MessageType.MODIFY_FAIL.getValue());
        }
        return JSONUtil.jsonResult(SystemContext.MessageType.MODIFY_SUCCESS.getValue());
    }
}
