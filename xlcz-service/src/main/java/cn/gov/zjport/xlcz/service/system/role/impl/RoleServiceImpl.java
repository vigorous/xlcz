/**************************************************************************
 * Copyright (c) 2006-2015 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：区域大通关系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.role.impl;

import cn.gov.zjport.xlcz.common.exception.CzException;
import cn.gov.zjport.xlcz.dao.system.RoleMapper;
import cn.gov.zjport.xlcz.dao.system.RoleMenuMapper;
import cn.gov.zjport.xlcz.dao.system.UserMapper;
import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;
import cn.gov.zjport.xlcz.domain.vo.RoleMenu;
import cn.gov.zjport.xlcz.service.system.base.impl.BaseServiceImpl;
import cn.gov.zjport.xlcz.service.system.role.RoleService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 角色服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

    /** 角色mapper */
    @Resource
    private RoleMapper roleMapper;

    /** 角色菜单mapper */
    @Resource
    private RoleMenuMapper roleMenuMapper;

    /** 用户Mapper */
    @Resource
    private UserMapper userMapper;

    /**
     * 通过角色ID查询角色信息
     *
     * @param id 角色ID
     * @return Role
     */
    @Override
    public Role findRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询部门所有角色
     *
     * @param deptId 部门ID
     * @return List<Role>
     */
    @Override
    public List<Role> findRolesByDeptId(Integer deptId) {
        return roleMapper.findRolesByDeptId(deptId);
    }

    /**
     * 查询部门角色
     *
     * @param deptId 部门ID
     * @return List<RoleJo>
     */
    @Override
    public List<RoleJo> findByDeptId(Integer deptId) {
        return roleMapper.findByDeptId(deptId);
    }

    /**
     * 角色列表分页查询
     *
     * @param roleSo 角色查询so
     * @return PageInfo<Role>
     */
    @Override
    public PageInfo<Role> findByPage(RoleSo roleSo) {
        PageHelper.startPage(roleSo.getPageIndex(), roleSo.getPageSize());
        List<Role> list = roleMapper.findByPage(roleSo);
        PageInfo<Role> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 新增角色和角色菜单权限
     *
     * @param role 角色
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertRoleAndAuth(Role role) {
        //根据部门ID查询部门的所有角色，判断新增的角色名称是否存在
        List<Role> roleList = roleMapper.findRolesByDeptId(role.getDeptId());
        for (Role r : roleList) {
            if (r.getRoleName().equals(role.getRoleName())) {
                throw new CzException("部门中角色名称已存在");
            }
        }
        //新增角色
        role.setDeletedFlag("0");
        role.setCreateId(getSessionUserId());
        role.setCreateTime(new Date());
        //返回role的主键id
        int roleId = roleMapper.insertSelective(role);
        //新增角色菜单权限
        List<RoleMenu> roleMenus = JSON.parseArray(role.getRoleMenuJson(), RoleMenu.class);
        for (RoleMenu roleMenu : roleMenus) {
            roleMenu.setRoleId(role.getId());
            roleMenu.setDeletedFlag("0");
            roleMenu.setCreateId(getSessionUserId());
            roleMenu.setCreateTime(new Date());
            roleMenuMapper.insertSelective(roleMenu);
        }
    }

    /**
     * 修改角色和角色菜单权限
     *
     * @param role 角色
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRoleAuth(Role role) {
        /* 修改角色信息 */
        role.setModifyId(getSessionUserId());
        role.setModifyTime(new Date());
        roleMapper.updateByPrimaryKeySelective(role);

        /* 修改角色菜单权限 */
        List<RoleMenu> roleMenus = JSON.parseArray(role.getRoleMenuJson(), RoleMenu.class);
        //删除角色原来的菜单权限
        roleMenuMapper.deleteByRoleId(role.getId());
        //新增修改之后的菜单权限
        for (RoleMenu roleMenu : roleMenus) {
            roleMenu.setDeletedFlag("0");
            roleMenu.setCreateId(getSessionUserId());
            roleMenu.setCreateTime(new Date());
            roleMenuMapper.insertSelective(roleMenu);
        }
    }

    /**
     * 逻辑删除角色
     *
     * @param ids 角色ID集合
     */
    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
            Integer key = Integer.parseInt(id);
            //判断该角色是否有用户在使用
            int count = userMapper.countUsersByRoleId(key);
            if (count > 0) {
                throw new CzException("该角色下有用户在使用!");
            }
            roleMapper.deleteById(key);
            //删除角色菜单权限
            roleMenuMapper.deleteByRoleId(key);
        }
    }

}
