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
 * 查验作业信息
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class CheckWorkInfo extends BaseVo implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 4138643742270181257L;

    /** 场站序号 */
    private String serialNo;

    /** 报关单号 */
    private String entryId;

    /** 提运单号 */
    private String billNo;

    /** 集装箱号 */
    private String containerNo;

    /** 集装箱类型 */
    private String containerType;

    /** 报关行代码 */
    private String agentCode;

    /** 报关行名称 */
    private String agentName;

    /** 客户单位代码（货代） */
    private String customerCode;

    /** 客户单位名称（货代） */
    private String customerName;

    /** 经营单位代码 */
    private String tradeCode;

    /** 经营单位名称 */
    private String tradeName;

    /** 货主单位代码 */
    private String ownerCode;

    /** 货主单位名称 */
    private String ownerName;

    /** 车牌号 */
    private Integer carNo;

    /** 进场时间 */
    private Date inTime;

    /** 出场时间 */
    private Date outTime;

    /** 吊上时间 */
    private Date upTime;

    /** 吊下时间 */
    private Date downTime;

    /** 吊箱次数 */
    private Integer hangboxTimes;

    /** 过磅次数 */
    private Integer weightingTimes;

    /** 滞箱天数 */
    private Integer detentionDays;

    /** 台架个数 */
    private Integer bracketNum;

    /** 掏箱类型（0：不掏，1：半掏，2：全掏） */
    private String unstuffingType;

    /** 船公司名称 */
    private String shippingCompany;

    /** 海关放行标志（0：未放行，1：已放行） */
    private String customPass;

    /** 放行时间 */
    private Date customPassTime;

    /** 查验标识（0：未查验，1：已查验） */
    private String checkPass;

    /** 查验放行时间 */
    private Date checkPassTime;

    /** 施封状态（0：未施封，1：已施封） */
    private String sealStatus;

    /** 施封时间 */
    private Date sealTime;

    /** 标箱个数 */
    private Integer teuNum;

    /** 集装箱数量 */
    private Integer containerNum;

    /** 日结状态（0：未日结，1：已日结） */
    private String dailyStatus;

    /** 费用ID */
    private Integer feeId;

    /** 数据类型 */
    private String dataType;

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
     * @return the containerType
     */
    public String getContainerType() {
        return containerType;
    }

    /**
     * @param containerType the containerType to set
     */
    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    /**
     * @return the agentCode
     */
    public String getAgentCode() {
        return agentCode;
    }

    /**
     * @param agentCode the agentCode to set
     */
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    /**
     * @return the agentName
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * @param agentName the agentName to set
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * @return the customerCode
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * @param customerCode the customerCode to set
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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
     * @return the tradeCode
     */
    public String getTradeCode() {
        return tradeCode;
    }

    /**
     * @param tradeCode the tradeCode to set
     */
    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    /**
     * @return the tradeName
     */
    public String getTradeName() {
        return tradeName;
    }

    /**
     * @param tradeName the tradeName to set
     */
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    /**
     * @return the ownerCode
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /**
     * @param ownerCode the ownerCode to set
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * @return the carNo
     */
    public Integer getCarNo() {
        return carNo;
    }

    /**
     * @param carNo the carNo to set
     */
    public void setCarNo(Integer carNo) {
        this.carNo = carNo;
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

    /**
     * @return the upTime
     */
    public Date getUpTime() {
        return upTime;
    }

    /**
     * @param upTime the upTime to set
     */
    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    /**
     * @return the downTime
     */
    public Date getDownTime() {
        return downTime;
    }

    /**
     * @param downTime the downTime to set
     */
    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    /**
     * @return the hangboxTimes
     */
    public Integer getHangboxTimes() {
        return hangboxTimes;
    }

    /**
     * @param hangboxTimes the hangboxTimes to set
     */
    public void setHangboxTimes(Integer hangboxTimes) {
        this.hangboxTimes = hangboxTimes;
    }

    /**
     * @return the weightingTimes
     */
    public Integer getWeightingTimes() {
        return weightingTimes;
    }

    /**
     * @param weightingTimes the weightingTimes to set
     */
    public void setWeightingTimes(Integer weightingTimes) {
        this.weightingTimes = weightingTimes;
    }

    /**
     * @return the detentionDays
     */
    public Integer getDetentionDays() {
        return detentionDays;
    }

    /**
     * @param detentionDays the detentionDays to set
     */
    public void setDetentionDays(Integer detentionDays) {
        this.detentionDays = detentionDays;
    }

    /**
     * @return the bracketNum
     */
    public Integer getBracketNum() {
        return bracketNum;
    }

    /**
     * @param bracketNum the bracketNum to set
     */
    public void setBracketNum(Integer bracketNum) {
        this.bracketNum = bracketNum;
    }

    /**
     * @return the unstuffingType
     */
    public String getUnstuffingType() {
        return unstuffingType;
    }

    /**
     * @param unstuffingType the unstuffingType to set
     */
    public void setUnstuffingType(String unstuffingType) {
        this.unstuffingType = unstuffingType;
    }

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

    /**
     * @return the customPass
     */
    public String getCustomPass() {
        return customPass;
    }

    /**
     * @param customPass the customPass to set
     */
    public void setCustomPass(String customPass) {
        this.customPass = customPass;
    }

    /**
     * @return the customPassTime
     */
    public Date getCustomPassTime() {
        return customPassTime;
    }

    /**
     * @param customPassTime the customPassTime to set
     */
    public void setCustomPassTime(Date customPassTime) {
        this.customPassTime = customPassTime;
    }

    /**
     * @return the checkPass
     */
    public String getCheckPass() {
        return checkPass;
    }

    /**
     * @param checkPass the checkPass to set
     */
    public void setCheckPass(String checkPass) {
        this.checkPass = checkPass;
    }

    /**
     * @return the checkPassTime
     */
    public Date getCheckPassTime() {
        return checkPassTime;
    }

    /**
     * @param checkPassTime the checkPassTime to set
     */
    public void setCheckPassTime(Date checkPassTime) {
        this.checkPassTime = checkPassTime;
    }

    /**
     * @return the sealStatus
     */
    public String getSealStatus() {
        return sealStatus;
    }

    /**
     * @param sealStatus the sealStatus to set
     */
    public void setSealStatus(String sealStatus) {
        this.sealStatus = sealStatus;
    }

    /**
     * @return the sealTime
     */
    public Date getSealTime() {
        return sealTime;
    }

    /**
     * @param sealTime the sealTime to set
     */
    public void setSealTime(Date sealTime) {
        this.sealTime = sealTime;
    }

    /**
     * @return the teuNum
     */
    public Integer getTeuNum() {
        return teuNum;
    }

    /**
     * @param teuNum the teuNum to set
     */
    public void setTeuNum(Integer teuNum) {
        this.teuNum = teuNum;
    }

    /**
     * @return the containerNum
     */
    public Integer getContainerNum() {
        return containerNum;
    }

    /**
     * @param containerNum the containerNum to set
     */
    public void setContainerNum(Integer containerNum) {
        this.containerNum = containerNum;
    }

    /**
     * @return the dailyStatus
     */
    public String getDailyStatus() {
        return dailyStatus;
    }

    /**
     * @param dailyStatus the dailyStatus to set
     */
    public void setDailyStatus(String dailyStatus) {
        this.dailyStatus = dailyStatus;
    }

    /**
     * @return the feeId
     */
    public Integer getFeeId() {
        return feeId;
    }

    /**
     * @param feeId the feeId to set
     */
    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}