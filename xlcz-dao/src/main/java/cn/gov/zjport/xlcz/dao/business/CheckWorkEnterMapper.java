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

import cn.gov.zjport.xlcz.domain.vo.CheckWorkEnter;

/**
 * 查验作业录入mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface CheckWorkEnterMapper {
    /**
     * 删除
     *
     * @param id
     * @return int
     */
    int deleteById(Integer id);

    /**
     * 新增
     *
     * @param checkWorkEnter
     * @return int
     */
    int insert(CheckWorkEnter checkWorkEnter);

    /**
     * 查询
     *
     * @param id
     * @return CheckWorkEnter
     */
    CheckWorkEnter selectById(Integer id);

    /**
     * 修改
     *
     * @param checkWorkEnter
     * @return int
     */
    int updateById(CheckWorkEnter checkWorkEnter);
}