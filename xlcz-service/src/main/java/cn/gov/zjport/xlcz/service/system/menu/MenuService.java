/**************************************************************************
 * Copyright (c) 2006-2015 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：区域大通关系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.menu;

import cn.gov.zjport.xlcz.domain.common.MenuTree;
import cn.gov.zjport.xlcz.domain.vo.Menu;

import java.util.List;

/**
 * 菜单服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface MenuService {
    /**
     * 通过ID查询菜单
     *
     * @param id 菜单ID
     * @return Menu
     */
    public Menu findById(Integer id);

    /**
     * 通过角色ID查询角色权限菜单
     *
     * @param roleId 角色ID
     * @return List<Menu>
     */
    public List<Menu> findByRoleId(Integer roleId);

    /**
     * 查询所有的菜单
     *
     * @return List<Menu>
     */
    List<Menu> findAllMenu();

    /**
     * 查询所有的菜单tree
     *
     * @return List<MenuTree>
     */
    List<MenuTree> findAllMenuTree();

    /**
     * 查询所有菜单标记角色的所有权限菜单
     *
     * @param roleId 角色ID
     * @return List<MenuTree>
     */
    List<MenuTree> findAllRoleMenuTree(Integer roleId);
}
