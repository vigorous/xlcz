/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.domain.so;

import cn.gov.zjport.xlcz.common.base.PageSo;

/**
 * 船公司识别设置so
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class ShipCompanySettingSo extends PageSo {
    /** 船公司名称 */
    private String shippingCompany;

    /**
     * @return the shippingCompany
     */
    public String getShippingCompany() {
        return shippingCompany;
    }

    /**
     * @param shippingCompany the shippingCompany to set
     */
    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }
}
