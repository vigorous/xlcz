/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.common.exception;

/**
 * 自定义异常
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class CzException extends RuntimeException {
    /** serialVersionUID */
    private static final long serialVersionUID = -7680597669632981568L;
    /** 异常信息 */
    private String msg;
    /** 异常编码 */
    private int code = 500;

    /**
     * 构造
     *
     * @param msg 异常信息
     */
    public CzException(String msg) {
        super(msg);
        this.msg = msg;
    }

    /**
     * 构造
     *
     * @param msg 异常信息
     * @param e   异常对象
     */
    public CzException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    /**
     * 构造
     *
     * @param msg  异常信息
     * @param code 异常编码
     */
    public CzException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    /**
     * 构造
     *
     * @param msg  异常信息
     * @param code 异常代码
     * @param e    异常对象
     */
    public CzException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
}
