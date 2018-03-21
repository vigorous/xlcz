package cn.gov.zjport.xlcz.domain.vo;

import cn.gov.zjport.xlcz.common.base.BaseVo;

public class RoleMenu extends BaseVo {
    /** serialVersionUID */
    private static final long serialVersionUID = -3729919593583626673L;
    /** 角色ID */
    private Integer roleId;
    /** 菜单ID */
    private Integer menuId;

    /**
     * @return the roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the menuId
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * @param menuId the menuId to set
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}