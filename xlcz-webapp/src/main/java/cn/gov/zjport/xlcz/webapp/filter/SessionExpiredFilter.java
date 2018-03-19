/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.filter;

import cn.gov.zjport.xlcz.common.context.Const;
import cn.gov.zjport.xlcz.domain.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * session失效过滤器
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class SessionExpiredFilter extends PathMatchingFilter {

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //User user = (User) securityManager.getSession(Const.SESSION_USER);
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
        if (user == null) {
            System.out.println("session过期");
            if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {
                //ajax的sesson处理
                //返回状态码
                onLoginFail(request, response);
                return false;
            } else {
                //普通的处理，直接给到下一个拦截器
                return true;
            }
        }

        return true;
    }

    //session过期给403状态码
    private void onLoginFail(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        httpResponse.setStatus(403);
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.getWriter().write("session超时了");
        //httpResponse.sendRedirect(httpRequest.getContextPath() + Const.LOGIN);
    }

}
