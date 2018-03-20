/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.domain.common;

import cn.gov.zjport.xlcz.common.base.BaseTree;

/**
 * 菜单树形类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class MenuTree extends BaseTree {
    /** serialVersionUID */
    private static final long serialVersionUID = -1214335805344668428L;
    /** 菜单名称 */
    private String menuName;
    /** 是否选中(1:选中，0:未选中) */
    private Integer checked;

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
     * @return the checked
     */
    public Integer getChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(Integer checked) {
        this.checked = checked;
    }
}
