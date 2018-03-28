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

import cn.gov.zjport.xlcz.domain.so.ShipCompanySettingSo;
import cn.gov.zjport.xlcz.domain.vo.ShipCompanySetting;
import cn.gov.zjport.xlcz.service.system.base.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 船公司识别设置服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface ShipCompanySettingService extends BaseService {

    /**
     * 分页查询
     *
     * @param shipCompanySettingSo 船公司识别设置查询so
     * @return
     */
    PageInfo<ShipCompanySetting> findByPage(ShipCompanySettingSo shipCompanySettingSo);

    /**
     * 通过船公司查询
     *
     * @param shipCompanySetting 船公司设置
     * @return List<ShipCompanySetting>
     */
    List<ShipCompanySetting> findByShippingCompany(ShipCompanySetting shipCompanySetting);

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return ShipCompanySetting
     */
    ShipCompanySetting findById(Integer id);

    /**
     * 新增
     *
     * @param shipCompanySetting 船公司识别设置
     * @return int
     */
    int insert(ShipCompanySetting shipCompanySetting);

    /**
     * 修改
     *
     * @param shipCompanySetting 船公司识别设置
     * @return int
     */
    int update(ShipCompanySetting shipCompanySetting);

    /**
     * 批量删除
     *
     * @param ids id字符串数组
     */
    void batchDelete(String[] ids);

}
