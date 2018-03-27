package cn.gov.zjport.xlcz.dao.business;


import cn.gov.zjport.xlcz.domain.vo.FeeSetting;

import java.util.List;

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