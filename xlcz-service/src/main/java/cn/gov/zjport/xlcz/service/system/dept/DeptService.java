/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.dept;

import cn.gov.zjport.xlcz.domain.json.DeptJo;
import cn.gov.zjport.xlcz.domain.vo.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 部门服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface DeptService {

    /**
     * 分页查询部门
     *
     * @param dept 部门对象
     * @return PageInfo<Dept>
     */
    PageInfo<Dept> findByPage(Dept dept);

    /**
     * 通过部门ID查询部门信息
     *
     * @param id 部门ID
     * @return Dept
     */
    Dept findById(Integer id);

    /**
     * 根据ID修改部门
     *
     * @param dept 部门对象
     * @return int
     */
    int updateById(Dept dept);

    /**
     * 新增部门
     *
     * @param dept 部门对象
     * @return int
     */
    int insertSelective(Dept dept);

    /**
     * 删除部门
     *
     * @param id 部门ID
     * @return int
     */
    int deleteById(String[] ids);

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
