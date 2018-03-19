/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.log.impl;

import cn.gov.zjport.xlcz.dao.system.LogMapper;
import cn.gov.zjport.xlcz.domain.dto.LogDto;
import cn.gov.zjport.xlcz.domain.vo.Log;
import cn.gov.zjport.xlcz.service.system.log.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    /**
     * 新增日志
     *
     * @param log 日志对象
     * @return int
     */
    @Override
    public int addLog(Log log) {
        return logMapper.insertSelective(log);
    }

    /**
     * 分页查询日志
     *
     * @param logDto 日志查询对象
     * @return PageInfo<LogDto>
     */
    @Override
    public PageInfo<LogDto> findByPage(LogDto logDto) {
        PageHelper.startPage(logDto.getPageIndex(), logDto.getPageSize());
        List<LogDto> list = logMapper.findByPage(logDto);
        PageInfo<LogDto> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据条件查询日志
     *
     * @param logDto 日志查询对象
     * @return List<LogDto>
     */
    @Override
    public List<LogDto> findByCondition(LogDto logDto) {
        List<LogDto> list = logMapper.findByPage(logDto);
        return list;
    }
}
