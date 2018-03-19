/**************************************************************************
 * Copyright (c) 2006-2015 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：区域大通关系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.system;

import cn.gov.zjport.xlcz.service.system.menu.MenuService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 菜单控制类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    /** 日志 */
    private final static Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单列表
     *
     * @return String
     */
    @RequestMapping(value = "/menuList")
    @ResponseBody
    public String menuList() {
        Session session = SecurityUtils.getSubject().getSession();
        String menuJson = (String) session.getAttribute("menuJson");
        LOGGER.debug("menuJson : {}", menuJson);
        System.out.println(menuJson);
        return menuJson;
    }
}
