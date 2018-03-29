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

import cn.gov.zjport.xlcz.domain.dto.UserDto;
import cn.gov.zjport.xlcz.domain.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 用户Mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface UserMapper {

    /**
     * 物理删除
     *
     * @param id 用户ID
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param user 用户
     * @return int
     */
    int insertSelective(User user);

    /**
     * 通过主键查询
     *
     * @param id 用户ID
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param user 用户
     * @return int
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 分页查询
     *
     * @param userDto 用户
     * @return List<userDto>
     */
    List<UserDto> findByPage(UserDto userDto);

    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    List<User> selectAllUser();

    /**
     * 通过用户名查询用户信息
     *
     * @param userName 用户名
     * @return User
     */
    User selectByUserName(String userName);

    /**
     * 通过用户名查询角色名称
     *
     * @param userName 用户名
     * @return Set<String>
     */
    Set<String> getRole(String userName);

    /**
     * 逻辑删除
     *
     * @param id 用户ID
     * @return int
     */
    int deleteById(Integer id);

    /**
     * 通过主键查询用户信息Dto
     *
     * @param id 用户ID
     * @return User
     */
    UserDto findUserDtoById(@Param("id") Integer id);

    /**
     * 统计该角色有多少用户
     *
     * @param roleId 角色ID
     * @return int
     */
    int countUsersByRoleId(Integer roleId);

}