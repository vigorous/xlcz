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
 * 查验作业费用
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class CheckWorkFee extends BaseVo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1580838112117678881L;

    /** 吊箱费 */
    private Double hangboxFee;

    /** 场地运行服务费(应收) */
    private Double placeReceiveFee;

    /** 返点 */
    private Double rebate;

    /** 场地运行服务费(实收) */
    private Double placeActualFee;

    /** 过磅费 */
    private Double weightingFee;

    /** 压缩费 */
    private Double packageFee;

    /** 台架费 */
    private Double bracketFee;

    /** 滞箱费 */
    private Double detentionFee;

    /** 掏箱费 */
    private Double unstuffingFee;

    /** 超时费 */
    private Double overtimeFee;

    /** 停车费 */
    private Double parkingFee;

    /** 其他费用 */
    private Double otherFee;

    /** 费用合计 */
    private Double totalFee;

    /**
     * @return the hangboxFee
     */
    public Double getHangboxFee() {
        return hangboxFee;
    }

    /**
     * @param hangboxFee the hangboxFee to set
     */
    public void setHangboxFee(Double hangboxFee) {
        this.hangboxFee = hangboxFee;
    }

    /**
     * @return the placeReceiveFee
     */
    public Double getPlaceReceiveFee() {
        return placeReceiveFee;
    }

    /**
     * @param placeReceiveFee the placeReceiveFee to set
     */
    public void setPlaceReceiveFee(Double placeReceiveFee) {
        this.placeReceiveFee = placeReceiveFee;
    }

    /**
     * @return the rebate
     */
    public Double getRebate() {
        return rebate;
    }

    /**
     * @param rebate the rebate to set
     */
    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    /**
     * @return the placeActualFee
     */
    public Double getPlaceActualFee() {
        return placeActualFee;
    }

    /**
     * @param placeActualFee the placeActualFee to set
     */
    public void setPlaceActualFee(Double placeActualFee) {
        this.placeActualFee = placeActualFee;
    }

    /**
     * @return the weightingFee
     */
    public Double getWeightingFee() {
        return weightingFee;
    }

    /**
     * @param weightingFee the weightingFee to set
     */
    public void setWeightingFee(Double weightingFee) {
        this.weightingFee = weightingFee;
    }

    /**
     * @return the packageFee
     */
    public Double getPackageFee() {
        return packageFee;
    }

    /**
     * @param packageFee the packageFee to set
     */
    public void setPackageFee(Double packageFee) {
        this.packageFee = packageFee;
    }

    /**
     * @return the bracketFee
     */
    public Double getBracketFee() {
        return bracketFee;
    }

    /**
     * @param bracketFee the bracketFee to set
     */
    public void setBracketFee(Double bracketFee) {
        this.bracketFee = bracketFee;
    }

    /**
     * @return the detentionFee
     */
    public Double getDetentionFee() {
        return detentionFee;
    }

    /**
     * @param detentionFee the detentionFee to set
     */
    public void setDetentionFee(Double detentionFee) {
        this.detentionFee = detentionFee;
    }

    /**
     * @return the unstuffingFee
     */
    public Double getUnstuffingFee() {
        return unstuffingFee;
    }

    /**
     * @param unstuffingFee the unstuffingFee to set
     */
    public void setUnstuffingFee(Double unstuffingFee) {
        this.unstuffingFee = unstuffingFee;
    }

    /**
     * @return the overtimeFee
     */
    public Double getOvertimeFee() {
        return overtimeFee;
    }

    /**
     * @param overtimeFee the overtimeFee to set
     */
    public void setOvertimeFee(Double overtimeFee) {
        this.overtimeFee = overtimeFee;
    }

    /**
     * @return the parkingFee
     */
    public Double getParkingFee() {
        return parkingFee;
    }

    /**
     * @param parkingFee the parkingFee to set
     */
    public void setParkingFee(Double parkingFee) {
        this.parkingFee = parkingFee;
    }

    /**
     * @return the otherFee
     */
    public Double getOtherFee() {
        return otherFee;
    }

    /**
     * @param otherFee the otherFee to set
     */
    public void setOtherFee(Double otherFee) {
        this.otherFee = otherFee;
    }

    /**
     * @return the totalFee
     */
    public Double getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee the totalFee to set
     */
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
}