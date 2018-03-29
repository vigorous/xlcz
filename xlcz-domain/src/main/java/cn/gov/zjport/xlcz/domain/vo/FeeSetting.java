/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/
package cn.gov.zjport.xlcz.domain.vo;

import cn.gov.zjport.xlcz.common.base.BaseVo;

import java.io.Serializable;

/**
 * 费率设置
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class FeeSetting extends BaseVo implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 7122130525778512869L;
    /** 费率代码 */
    private String feeCode;
    /** 费率名称 */
    private String feeName;
    /** 费率值 */
    private Double feeValue;

    /**
     * @return the feeCode
     */
    public String getFeeCode() {
        return feeCode;
    }

    /**
     * @param feeCode the feeCode to set
     */
    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    /**
     * @return the feeName
     */
    public String getFeeName() {
        return feeName;
    }

    /**
     * @param feeName the feeName to set
     */
    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    /**
     * @return the feeValue
     */
    public Double getFeeValue() {
        return feeValue;
    }

    /**
     * @param feeValue the feeValue to set
     */
    public void setFeeValue(Double feeValue) {
        this.feeValue = feeValue;
    }
}