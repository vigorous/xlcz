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

import cn.gov.zjport.xlcz.domain.vo.CheckWorkEnter;
import cn.gov.zjport.xlcz.service.business.CheckWorkEnterService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 查验作业录入管理
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/checkworkEnter")
public class CheckWorkEnterController extends BaseController {

    /** serialVersionUID */
    private static final long serialVersionUID = 4686885941162910510L;

    /** 路劲前缀 */
    private static final String PREFIX = "business/parkoperate/checkworkenter/";

    /** 查验作业录入服务 */
    @Autowired
    private CheckWorkEnterService checkWorkEnterService;


    /**
     * 查验作业录入首页
     *
     * @return String
     */
    @RequestMapping(value = "/index")
    public String index() {
        return PREFIX + "checkwork_enter";
    }

    /**
     * 新增
     *
     * @return Object
     */
    @RequestMapping(value = "/addCheckWork")
    @ResponseBody
    public Object addCheckWork(CheckWorkEnter checkWorkEnter) {
        return "";
    }
}
