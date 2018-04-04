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
 * 查验作业查询so
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class CheckWorkInfoSo extends PageSo {

    /** 场站序号 */
    private String serialNo;

    /** 报关单号 */
    private String entryId;

    /** 集装箱号 */
    private String containerNo;

    /** 提运单号 */
    private String billNo;

    /** 客户名称 */
    private String customerName;

    /** 开始出场日期 */
    private String startOutTime;

    /** 结束出场日期 */
    private String endOutTime;

    /**
     * @return the serialNo
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * @param serialNo the serialNo to set
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * @return the entryId
     */
    public String getEntryId() {
        return entryId;
    }

    /**
     * @param entryId the entryId to set
     */
    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    /**
     * @return the containerNo
     */
    public String getContainerNo() {
        return containerNo;
    }

    /**
     * @param containerNo the containerNo to set
     */
    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    /**
     * @return the billNo
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * @param billNo the billNo to set
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the startOutTime
     */
    public String getStartOutTime() {
        return startOutTime;
    }

    /**
     * @param startOutTime the startOutTime to set
     */
    public void setStartOutTime(String startOutTime) {
        this.startOutTime = startOutTime;
    }

    /**
     * @return the endOutTime
     */
    public String getEndOutTime() {
        return endOutTime;
    }

    /**
     * @param endOutTime the endOutTime to set
     */
    public void setEndOutTime(String endOutTime) {
        this.endOutTime = endOutTime;
    }
}
