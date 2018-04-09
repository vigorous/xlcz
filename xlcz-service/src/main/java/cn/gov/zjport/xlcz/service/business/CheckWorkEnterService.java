/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.business;

import cn.gov.zjport.xlcz.domain.vo.CheckWorkEnter;
import cn.gov.zjport.xlcz.service.system.base.BaseService;

/**
 * 查验作业录入服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface CheckWorkEnterService extends BaseService {
    /**
     * 批量录入
     *
     * @param checkWorkEnter 查验作业录入记录信息
     */
    void batchInsert(CheckWorkEnter checkWorkEnter);
}
