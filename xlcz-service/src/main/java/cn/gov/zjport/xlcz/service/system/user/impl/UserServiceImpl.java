/**************************************************************************
 * Copyright (c) 2006-2015 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：区域大通关系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.user.impl;

import cn.gov.zjport.xlcz.dao.system.UserMapper;
import cn.gov.zjport.xlcz.domain.dto.UserDto;
import cn.gov.zjport.xlcz.domain.vo.User;
import cn.gov.zjport.xlcz.service.system.user.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * 用户服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 分页查询
     *
     * @param userDto 用户
     * @return PageInfo<UserDto>
     */
    @Override
    public PageInfo<UserDto> findByPage(UserDto userDto) {
        PageHelper.startPage(userDto.getPageIndex(), userDto.getPageSize());
        List<UserDto> list = userMapper.findByPage(userDto);
        PageInfo<UserDto> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 查询所有的用户信息
     *
     * @return List<User>
     */
    @Override
    public List<User> findAllUser() {
        return userMapper.selectAllUser();
    }

    /**
     * 通过主键查询用户信息
     *
     * @param id 用户ID
     * @return User
     */
    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键查询用户信息Dto
     *
     * @param id 用户ID
     * @return User
     */
    @Override
    public UserDto findUserDtoById(Integer id) {
        return userMapper.findUserDtoById(id);
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名称
     * @return User
     */
    @Override
    public User findByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    /**
     * 通过用户名查询角色名称
     *
     * @param userName 用户名
     * @return Set<String>
     */
    @Override
    public Set<String> getRoleByUserName(String userName) {
        return userMapper.getRole(userName);
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return int
     */
    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    /**
     * 批量删除用户
     *
     * @param ids 用户集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchDeleteById(String[] ids) {
        for (String id : ids) {
            userMapper.deleteById(Integer.parseInt(id));
        }
    }

    /**
     * 新增用户
     *
     * @param user 用户
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(User user) {
        return userMapper.insertSelective(user);
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return int
     */
    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
