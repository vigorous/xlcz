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
import java.util.Date;

/**
 * 查验作业录入记录信息
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class CheckWorkEnter extends BaseVo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -8817580560004781572L;

    /** 场站序号 */
    private String serialNo;

    /** 报关单号 */
    private String entryId;

    /** 提运单号 */
    private String billNo;

    /** 集装箱号 */
    private String containerNo;

    /** 集装箱号字符串（已逗号隔开） */
    private String containerNos;

    /** 进场时间 */
    private Date inTime;

    /** 出场时间 */
    private Date outTime;

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
     * @return the containerNos
     */
    public String getContainerNos() {
        return containerNos;
    }

    /**
     * @param containerNos the containerNos to set
     */
    public void setContainerNos(String containerNos) {
        this.containerNos = containerNos;
    }

    /**
     * @return the inTime
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * @param inTime the inTime to set
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * @return the outTime
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * @param outTime the outTime to set
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}