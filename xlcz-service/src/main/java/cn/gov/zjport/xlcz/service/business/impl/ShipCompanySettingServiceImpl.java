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

import cn.gov.zjport.xlcz.dao.business.ShipCompanySettingMapper;
import cn.gov.zjport.xlcz.domain.so.ShipCompanySettingSo;
import cn.gov.zjport.xlcz.domain.vo.ShipCompanySetting;
import cn.gov.zjport.xlcz.service.business.ShipCompanySettingService;
import cn.gov.zjport.xlcz.service.system.base.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 船公司识别设置服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class ShipCompanySettingServiceImpl extends BaseServiceImpl implements ShipCompanySettingService {

    /** 船公司识别设置mapper */
    @Resource
    private ShipCompanySettingMapper shipCompanySettingMapper;

    /**
     * 分页查询
     *
     * @param shipCompanySettingSo 船公司识别设置查询so
     * @return
     */
    @Override
    public PageInfo<ShipCompanySetting> findByPage(ShipCompanySettingSo shipCompanySettingSo) {
        PageHelper.startPage(shipCompanySettingSo.getPageIndex(), shipCompanySettingSo.getPageSize());
        List<ShipCompanySetting> list = shipCompanySettingMapper.findByPage(shipCompanySettingSo);
        PageInfo<ShipCompanySetting> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 通过船公司查询
     *
     * @param shipCompanySetting 船公司设置
     * @return List<ShipCompanySetting>
     */
    @Override
    public List<ShipCompanySetting> findByShippingCompany(ShipCompanySetting shipCompanySetting) {
        return shipCompanySettingMapper.findByShippingCompany(shipCompanySetting);
    }

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return ShipCompanySetting
     */
    @Override
    public ShipCompanySetting findById(Integer id) {
        return shipCompanySettingMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     *
     * @param shipCompanySetting 船公司识别设置
     * @return int
     */
    @Override
    public int insert(ShipCompanySetting shipCompanySetting) {
        return shipCompanySettingMapper.insertSelective(shipCompanySetting);
    }

    /**
     * 修改
     *
     * @param shipCompanySetting 船公司识别设置
     * @return int
     */
    @Override
    public int update(ShipCompanySetting shipCompanySetting) {
        return shipCompanySettingMapper.updateByPrimaryKeySelective(shipCompanySetting);
    }

    /**
     * 批量删除
     *
     * @param ids id字符串数组
     */
    @Override
    public void batchDelete(String[] ids) {
        for (String id : ids) {
            Integer key = Integer.parseInt(id);
            shipCompanySettingMapper.deleteByPrimaryKey(key);
        }
    }
}
