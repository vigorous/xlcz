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

import cn.gov.zjport.xlcz.domain.vo.FeeSetting;

import java.util.List;

/**
 * 费率设置Mapper
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface FeeSettingMapper {
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
     * @param feeSetting 费率设置
     * @return int
     */
    int insertSelective(FeeSetting feeSetting);

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return FeeSetting
     */
    FeeSetting selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param feeSetting 费率设置
     * @return int
     */
    int updateByPrimaryKeySelective(FeeSetting feeSetting);

    /**
     * 查询所有的费率设置
     *
     * @return List<FeeSetting>
     */
    List<FeeSetting> findAll();

    /**
     * 修改费率值
     *
     * @param feeSetting 费率
     * @return int
     */
    int updateFeeValueById(FeeSetting feeSetting);

}