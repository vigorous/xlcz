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

import cn.gov.zjport.xlcz.domain.so.ShipCompanySettingSo;
import cn.gov.zjport.xlcz.domain.vo.ShipCompanySetting;

import java.util.List;

/**
 * 船公司识别设置Mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface ShipCompanySettingMapper {

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param shipCompanySetting 船公司设置对象
     * @return int
     */
    int insertSelective(ShipCompanySetting shipCompanySetting);

    /**
     * 根据ID查询
     *
     * @param id 主键
     * @return ShipCompanySetting
     */
    ShipCompanySetting selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param shipCompanySetting 船公司设置对象
     * @return int
     */
    int updateByPrimaryKeySelective(ShipCompanySetting shipCompanySetting);

    /**
     * 分页查询
     *
     * @param shipCompanySettingSo 船公司设置so
     * @return List<ShipCompanySetting>
     */
    List<ShipCompanySetting> findByPage(ShipCompanySettingSo shipCompanySettingSo);

    /**
     * 通过船公司查询
     *
     * @param shipCompanySetting 船公司设置
     * @return List<ShipCompanySetting>
     */
    List<ShipCompanySetting> findByShippingCompany(ShipCompanySetting shipCompanySetting);

}