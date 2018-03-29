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

import cn.gov.zjport.xlcz.domain.json.DeptJo;
import cn.gov.zjport.xlcz.domain.vo.Dept;

import java.util.List;

/**
 * 部门Mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface DeptMapper {
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
     * @param dept 部门
     * @return int
     */
    int insertSelective(Dept dept);

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return Dept
     */
    Dept selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param dept 部门
     * @return int
     */
    int updateByPrimaryKeySelective(Dept dept);

    /**
     * 分页查询部门
     *
     * @param dept 部门对象
     * @return List<Dept>
     */
    List<Dept> findByPage(Dept dept);

    /**
     * 通过部门名称查询部门
     *
     * @param dept 部门对象
     * @return List<Dept>
     */
    List<Dept> findByDeptName(Dept dept);

    /**
     * 部门下拉框
     *
     * @return List<DeptJo>
     */
    List<DeptJo> findAll();
}