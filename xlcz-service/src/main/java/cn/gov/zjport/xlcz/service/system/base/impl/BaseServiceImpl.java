/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.base.impl;

import cn.gov.zjport.xlcz.common.context.Const;
import cn.gov.zjport.xlcz.domain.vo.User;
import cn.gov.zjport.xlcz.service.system.base.BaseService;
import org.apache.shiro.SecurityUtils;

/**
 * 基础服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class BaseServiceImpl implements BaseService {
    /**
     * 获取SessionUser对象
     *
     * @return User
     */
    @Override
    public User getSessionUser() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
        return user;
    }

    /**
     * 获取session中user中的ID
     *
     * @return Integer
     */
    @Override
    public Integer getSessionUserId() {
        return getSessionUser().getId();
    }
}
