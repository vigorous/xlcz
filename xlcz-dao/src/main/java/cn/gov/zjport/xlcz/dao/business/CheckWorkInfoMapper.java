/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/
package cn.gov.zjport.xlcz.dao.business;

import cn.gov.zjport.xlcz.domain.so.CheckWorkInfoSo;
import cn.gov.zjport.xlcz.domain.vo.CheckWorkInfo;

import java.util.List;

/**
 * 查验作业Mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface CheckWorkInfoMapper {
    /**
     * 删除
     *
     * @param id 主键
     * @return int 删除数
     */
    int deleteById(Integer id);

    /**
     * 新增
     *
     * @param checkWorkInfo 查验作业信息
     * @return int 新增数
     */
    int insert(CheckWorkInfo checkWorkInfo);

    /**
     * 查询
     *
     * @param id 主键
     * @return CheckWorkInfo 查验作业信息
     */
    CheckWorkInfo selectById(Integer id);

    /**
     * 修改
     *
     * @param checkWorkInfo 查验作业信息
     * @return int 修改数
     */
    int updateById(CheckWorkInfo checkWorkInfo);

    /**
     * 分页查询
     *
     * @param checkWorkInfoSo 查验作业so
     * @return List<CheckWorkInfo>
     */
    List<CheckWorkInfo> findByPage(CheckWorkInfoSo checkWorkInfoSo);
}