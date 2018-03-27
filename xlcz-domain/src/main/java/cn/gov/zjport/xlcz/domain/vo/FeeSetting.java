package cn.gov.zjport.xlcz.domain.vo;

import cn.gov.zjport.xlcz.common.base.BaseVo;

import java.io.Serializable;

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