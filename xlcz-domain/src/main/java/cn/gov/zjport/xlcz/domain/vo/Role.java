package cn.gov.zjport.xlcz.domain.vo;

import cn.gov.zjport.xlcz.common.base.BaseVo;

import java.io.Serializable;

public class Role extends BaseVo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -8491750650512914844L;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色标题
     */
    private String roleTitle;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 排序
     */
    private Long orders;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the roleTitle
     */
    public String getRoleTitle() {
        return roleTitle;
    }

    /**
     * @param roleTitle the roleTitle to set
     */
    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    /**
     * @return the roleDesc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * @param roleDesc the roleDesc to set
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * @return the orders
     */
    public Long getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Long orders) {
        this.orders = orders;
    }

    /**
     * @return the deptId
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

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
}