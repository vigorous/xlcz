package cn.gov.zjport.xlcz.dao.business;

import cn.gov.zjport.xlcz.domain.so.ShipCompanySettingSo;
import cn.gov.zjport.xlcz.domain.vo.ShipCompanySetting;

import java.util.List;

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