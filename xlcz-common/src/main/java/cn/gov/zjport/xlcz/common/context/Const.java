/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.common.context;

/**
 * 常量类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class Const {
    /** session中user对象 */
    public static final String SESSION_USER = "sessionUser";
    /** 菜单的json字符串 */
    public static final String MENU_JSON = "menuJson";
    /** 成功代码:1 */
    public static final Integer CODE_SUCCESS = 1;
    /** 失败代码:0 */
    public static final Integer CODE_FAIL = 0;
    /** 成功描述 */
    public static final String SUCCESS_DESC = "成功";
    /** 失败描述 */
    public static final String FAIL_DESC = "失败";
    /** 登录地址 */
    public static final String LOGIN = "/login/toLogin.do";
    /** 不对匹配该值的访问路径拦截（正则） */
    public static final String NO_INTERCEPTOR_PATH = "/login/((toLogin)|(login)|(logout)).*";
    /** 分隔符 */
    public static final String CONTAINER_NO_SEPARATER = "\n";
}
