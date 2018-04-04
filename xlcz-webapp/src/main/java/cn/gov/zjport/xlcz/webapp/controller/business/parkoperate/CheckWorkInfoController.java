/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.business.parkoperate;

import cn.gov.zjport.xlcz.common.base.PageResult;
import cn.gov.zjport.xlcz.domain.so.CheckWorkInfoSo;
import cn.gov.zjport.xlcz.domain.vo.CheckWorkInfo;
import cn.gov.zjport.xlcz.domain.vo.FeeSetting;
import cn.gov.zjport.xlcz.service.business.CheckWorkInfoService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 查验作业管理
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/checkwork")
public class CheckWorkInfoController extends BaseController {
    /** serialVersionUID */
    private static final long serialVersionUID = 6986242525269990626L;

    /** 路劲前缀 */
    private static final String PREFIX = "business/parkoperate/checkwork/";

    /** 查验作业服务 */
    @Autowired
    private CheckWorkInfoService checkWorkInfoService;

    /**
     * 查验作业首页
     *
     * @return String
     */
    @RequestMapping(value = "/index")
    public String index() {
        return PREFIX + "checkwork_list";
    }

    /**
     * 分页查询
     *
     * @param checkWorkInfoSo 查验作业so
     * @return Object
     */
    @RequestMapping(value = "/checkWorkList")
    @ResponseBody
    public Object checkWorkList(CheckWorkInfoSo checkWorkInfoSo) {
        PageResult<CheckWorkInfo> pageResult = checkWorkInfoService.findByPage(checkWorkInfoSo);
        return JSON.toJSONString(pageResult);
    }

    /**
     * 修改页面
     *
     * @param checkWorkInfo 查验作业信息
     * @param request       请求
     * @return String
     */
    public String toEdit(CheckWorkInfo checkWorkInfo, HttpServletRequest request) {
        return PREFIX + "checkwork_edit";
    }

    /**
     * 修改
     *
     * @param checkWorkInfo 查验作业信息
     * @param feeSetting    费率设置
     * @return Object
     */
    public Object editCheckWork(CheckWorkInfo checkWorkInfo, FeeSetting feeSetting) {
        return "";
    }
}
