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

import cn.gov.zjport.xlcz.dao.system.RoleMapper;
import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;
import cn.gov.zjport.xlcz.service.system.role.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

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
}
