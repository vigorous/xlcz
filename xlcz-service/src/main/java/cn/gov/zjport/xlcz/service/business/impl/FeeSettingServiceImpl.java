/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.business.impl;

import cn.gov.zjport.xlcz.dao.business.FeeSettingMapper;
import cn.gov.zjport.xlcz.domain.vo.FeeSetting;
import cn.gov.zjport.xlcz.service.business.FeeSettingService;
import cn.gov.zjport.xlcz.service.system.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 费率设置服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class FeeSettingServiceImpl extends BaseServiceImpl implements FeeSettingService {

    /** 费率设置mapper */
    @Resource
    private FeeSettingMapper feeSettingMapper;

    /**
     * 查询所有费率设置
     *
     * @return List<FeeSetting>
     */
    @Override
    public List<FeeSetting> findAll() {
        return feeSettingMapper.findAll();
    }

    /**
     * 通过主键修改
     *
     * @param feeSetting 费率设置
     * @return int
     */
    @Override
    public int updateById(FeeSetting feeSetting) {
        return feeSettingMapper.updateByPrimaryKeySelective(feeSetting);
    }

    /**
     * 修改费率
     *
     * @param feeSettinglist 费率list集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFeeSettings(List<FeeSetting> feeSettinglist) {
        for (FeeSetting feeSetting : feeSettinglist) {
            feeSetting.setModifyId(this.getSessionUserId());
            feeSetting.setModifyTime(new Date());
            feeSettingMapper.updateFeeValueById(feeSetting);
        }
    }

}
