package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.vo.RoleMenu;

public interface RoleMenuMapper {
    /**
     * 物理删除
     *
     * @param id 主键
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param roleMenu 角色菜单
     * @return int
     */
    int insertSelective(RoleMenu roleMenu);

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return RoleMenu
     */
    RoleMenu selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param roleMenu 角色菜单
     * @return int
     */
    int updateByPrimaryKeySelective(RoleMenu roleMenu);


    /**
     * 删除角色的菜单权限
     *
     * @param roleId 角色ID
     * @return int
     */
    int deleteByRoleId(Integer roleId);
}