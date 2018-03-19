package cn.gov.zjport.xlcz.common.base;

import cn.gov.zjport.xlcz.common.context.Const;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.InvalidSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 基础控制类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class DefaultController implements Serializable {
    /** 日志 */
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 得到request对象
     *
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }


    /**
     * 统一异常处理
     *
     * @param request   请求
     * @param response  响应
     * @param exception 异常
     * @return String
     */
    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        LOGGER.error("统一异常处理：", exception);
        request.setAttribute("ex", exception);
        if (null != request.getHeader(BaseConstant.X_REQUESTED_WITH) && BaseConstant.XML_HTTP_REQUEST.equalsIgnoreCase(request.getHeader(BaseConstant.X_REQUESTED_WITH))) {
            LOGGER.info("ajax 异常...");
            request.setAttribute("requestHeader", "ajax");
        }
        // shiro没有权限异常
        if (exception instanceof UnauthorizedException) {
            return "404";
        }
        // shiro会话已过期异常
        if (exception instanceof InvalidSessionException) {
            return "login";
        }
        return "404";
    }

}
