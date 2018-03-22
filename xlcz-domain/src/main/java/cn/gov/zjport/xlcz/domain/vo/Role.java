package cn.gov.zjport.xlcz.domain.vo;

import cn.gov.zjport.xlcz.common.base.BaseVo;

import java.io.Serializable;

public class Role extends BaseVo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -8491750650512914844L;
    /** 角色名称 */
    private String roleName;

    /** 角色描述 */
    private String roleDesc;

    /** 部门ID */
    private Integer deptId;

    /** 部门名称 */
    private String deptName;

    /** 角色菜单json字符串 */
    private String roleMenuJson;

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

    /**
     * @return the roleMenuJson
     */
    public String getRoleMenuJson() {
        return roleMenuJson;
    }

    /**
     * @param roleMenuJson the roleMenuJson to set
     */
    public void setRoleMenuJson(String roleMenuJson) {
        this.roleMenuJson = roleMenuJson;
    }
}