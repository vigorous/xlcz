package cn.gov.zjport.xlcz.domain.vo;

import cn.gov.zjport.xlcz.common.base.BaseVo;

import java.io.Serializable;

public class Dept extends BaseVo implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1552574095590133475L;
    /** 部门名称 */
    private String deptName;
    /** 部门描述 */
    private String deptDesc;

    /**
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName the deptName to set
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return the deptDesc
     */
    public String getDeptDesc() {
        return deptDesc;
    }

    /**
     * @param deptDesc the deptDesc to set
     */
    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }
}