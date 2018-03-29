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
 * 菜单
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class Menu extends BaseVo implements Serializable {
    /** 菜单名称 */
    private String menuName;
    /** 菜单类型（1：菜单，2：按钮） */
    private Byte menuType;
    /** 权限值 */
    private String permissionValue;
    /** 菜单URL路径 */
    private String menuUri;
    /** 图标 */
    private String icon;
    /** 状态（0:禁止，1:正常） */
    private Byte status;
    /** 排序 */
    private Long orders;
    /** 所属上级 */
    private Integer pid;

    /**
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return the menuType
     */
    public Byte getMenuType() {
        return menuType;
    }

    /**
     * @param menuType the menuType to set
     */
    public void setMenuType(Byte menuType) {
        this.menuType = menuType;
    }

    /**
     * @return the permissionValue
     */
    public String getPermissionValue() {
        return permissionValue;
    }

    /**
     * @param permissionValue the permissionValue to set
     */
    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    /**
     * @return the menuUri
     */
    public String getMenuUri() {
        return menuUri;
    }

    /**
     * @param menuUri the menuUri to set
     */
    public void setMenuUri(String menuUri) {
        this.menuUri = menuUri;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Byte status) {
        this.status = status;
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
     * @return the pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}