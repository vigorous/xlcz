package cn.gov.zjport.xlcz.domain.vo;

import cn.gov.zjport.xlcz.common.base.BaseVo;

import java.io.Serializable;

public class ShipCompanySetting extends BaseVo implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = -4566805926409241472L;
    /** 船公司名称 */
    private String shippingCompany;
    /** 船公司规则 */
    private String codeRule;

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
     * @return the codeRule
     */
    public String getCodeRule() {
        return codeRule;
    }

    /**
     * @param codeRule the codeRule to set
     */
    public void setCodeRule(String codeRule) {
        this.codeRule = codeRule;
    }
}