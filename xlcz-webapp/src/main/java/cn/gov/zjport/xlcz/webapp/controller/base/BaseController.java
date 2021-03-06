/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.base;

import cn.gov.zjport.xlcz.common.base.DefaultController;
import cn.gov.zjport.xlcz.common.context.Const;
import cn.gov.zjport.xlcz.domain.vo.User;
import org.apache.shiro.SecurityUtils;

/**
 * web项目基础控制类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class BaseController extends DefaultController {

    /**
     * 获取session中User对象
     *
     * @return User
     */
    public User getSessionUser() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
        return user;
    }

    /**
     * 获取session中User对象ID值
     *
     * @return
     */
    public Integer getSessionUserId() {
        return getSessionUser().getId();
    }
}
