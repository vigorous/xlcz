/**************************************************************************
 * Copyright (c) 2006-2015 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：区域大通关系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.menu.impl;

import cn.gov.zjport.xlcz.dao.system.MenuMapper;
import cn.gov.zjport.xlcz.domain.common.MenuTree;
import cn.gov.zjport.xlcz.domain.vo.Menu;
import cn.gov.zjport.xlcz.service.system.menu.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 通过ID查询菜单
     *
     * @param id 菜单ID
     * @return Menu
     */
    @Override
    public Menu findById(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过角色ID查询角色权限菜单
     *
     * @param roleId 角色ID
     * @return List<Menu>
     */
    @Override
    public List<Menu> findByRoleId(Integer roleId) {
        return menuMapper.findByRoleId(roleId);
    }

    /**
     * 查询所有的菜单
     *
     * @return List<Menu>
     */
    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    /**
     * 查询所有的菜单tree
     *
     * @return List<MenuTree>
     */
    @Override
    public List<MenuTree> findAllMenuTree() {
        return menuMapper.findAllMenuTree();
    }

    /**
     * 查询所有菜单标记角色的所有权限菜单
     *
     * @param roleId 角色ID
     * @return List<MenuTree>
     */
    @Override
    public List<MenuTree> findAllRoleMenuTree(Integer roleId) {
        return menuMapper.findAllRoleMenuTree(roleId);
    }
}
