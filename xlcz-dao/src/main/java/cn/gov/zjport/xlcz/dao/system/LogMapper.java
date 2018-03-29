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

import cn.gov.zjport.xlcz.domain.dto.LogDto;
import cn.gov.zjport.xlcz.domain.vo.Log;

import java.util.List;

/**
 * 日志Mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface LogMapper {
    /**
     * 物理删除
     *
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param log 日志
     * @return
     */
    int insertSelective(Log log);

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return
     */
    Log selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param log 日志
     * @return int
     */
    int updateByPrimaryKeySelective(Log log);

    /**
     * 分页查询
     *
     * @param logDto 日志查询对象
     * @return List<LogDto>
     */
    List<LogDto> findByPage(LogDto logDto);
}