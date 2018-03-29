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

import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色Mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface RoleMapper {

    /**
     * 物理删除
     *
     * @param id 角色ID
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 选择新增
     *
     * @param role
     * @return
     */
    int insertSelective(Role role);

    /**
     * 根据主键查询角色
     *
     * @param id 角色ID
     * @return Role
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param role
     * @return
     */
    int updateByPrimaryKeySelective(Role role);

    /**
     * 查询部门所有角色
     *
     * @param deptId 部门ID
     * @return List<Role>
     */
    List<Role> findRolesByDeptId(Integer deptId);

    /**
     * 查询部门角色RoleJo对象
     *
     * @param detpId 部门ID
     * @return List<RoleJo>
     */
    List<RoleJo> findByDeptId(@Param("deptId") Integer detpId);

    /**
     * 角色列表分页查询
     *
     * @param roleSo 角色查询so
     * @return List<Role>
     */
    List<Role> findByPage(RoleSo roleSo);

    /**
     * 删除角色
     *
     * @param id 角色ID
     * @return int
     */
    int deleteById(Integer id);
}