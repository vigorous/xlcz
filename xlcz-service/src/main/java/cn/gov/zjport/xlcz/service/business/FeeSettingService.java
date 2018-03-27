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

import cn.gov.zjport.xlcz.domain.vo.FeeSetting;
import cn.gov.zjport.xlcz.service.system.base.BaseService;

import java.util.List;

/**
 * 费率设置服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface FeeSettingService extends BaseService{
    /**
     * 查询所有费率设置
     *
     * @return List<FeeSetting>
     */
    List<FeeSetting> findAll();

    /**
     * 通过主键修改
     *
     * @param feeSetting 费率设置
     * @return int
     */
    int updateById(FeeSetting feeSetting);

    /**
     * 修改费率
     *
     * @param feeSettinglist 费率list集合
     */
    void updateFeeSettings(List<FeeSetting> feeSettinglist);
}
