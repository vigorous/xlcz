/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/
package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.common.MenuTree;
import cn.gov.zjport.xlcz.domain.vo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单Mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface MenuMapper {
    /**
     * 物理删除
     *
     * @param id 主键
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param menu 菜单
     * @return int
     */
    int insertSelective(Menu menu);

    /**
     * 通过主键查询
     *
     * @param id
     * @return
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param menu 菜单
     * @return int
     */
    int updateByPrimaryKeySelective(Menu menu);

    /**
     * 通过角色ID查询角色菜单权限
     *
     * @param roleId 角色ID
     * @return List<Menu>
     */
    List<Menu> findByRoleId(@Param("roleId") Integer roleId);

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