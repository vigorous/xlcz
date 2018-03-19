/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.dept.impl;

import cn.gov.zjport.xlcz.dao.system.DeptMapper;
import cn.gov.zjport.xlcz.domain.json.DeptJo;
import cn.gov.zjport.xlcz.domain.vo.Dept;
import cn.gov.zjport.xlcz.service.system.dept.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    /** 部门mapper */
    @Resource
    private DeptMapper deptMapper;

    /**
     * 分页查询部门
     *
     * @param dept 部门对象
     * @return PageInfo<Dept>
     */
    @Override
    public PageInfo<Dept> findByPage(Dept dept) {
        PageHelper.startPage(dept.getPageIndex(), dept.getPageSize());
        List<Dept> list = deptMapper.findByPage(dept);
        PageInfo<Dept> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 通过部门ID查询部门信息
     *
     * @param id 部门ID
     * @return Dept
     */
    @Override
    public Dept findById(Integer id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据ID修改部门
     *
     * @param dept 部门对象
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(Dept dept) {
        return deptMapper.updateByPrimaryKeySelective(dept);
    }

    /**
     * 新增部门
     *
     * @param dept 部门对象
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Dept dept) {
        return deptMapper.insertSelective(dept);
    }

    /**
     * 删除部门
     *
     * @param ids 部门ID集合
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(String[] ids) {
        for (String id : ids) {
            Integer key = Integer.parseInt(id);
            deptMapper.deleteByPrimaryKey(key);
        }
        return ids.length;
    }

    /**
     * 通过部门名称查询部门
     *
     * @param dept 部门对象
     * @return List<Dept>
     */
    @Override
    public List<Dept> findByDeptName(Dept dept) {
        return deptMapper.findByDeptName(dept);
    }

    /**
     * 部门下拉框
     *
     * @return List<DeptJo>
     */
    @Override
    public List<DeptJo> findAll() {
        return deptMapper.findAll();
    }
}
