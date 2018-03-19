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

import cn.gov.zjport.xlcz.common.context.Const;
import org.apache.shiro.SecurityUtils;

/**
 * 系统工具类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class SystemUtil {

    /**
     * 获取session中User对象
     *
     * @return Object
     */
    public static Object getSessionUser() {
        Object object = SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
        return object;
    }
}
