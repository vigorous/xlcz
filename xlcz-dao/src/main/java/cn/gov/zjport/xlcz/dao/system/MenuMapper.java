package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.common.MenuTree;
import cn.gov.zjport.xlcz.domain.vo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
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
     * @param menu 菜单
     * @return int
     */
    int insertSelective(Menu menu);

    /**
     * 通过主键查询
     *
     * @param id
     * @return
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param menu 菜单
     * @return int
     */
    int updateByPrimaryKeySelective(Menu menu);

    /**
     * 通过角色ID查询角色菜单权限
     *
     * @param roleId 角色ID
     * @return List<Menu>
     */
    List<Menu> findByRoleId(@Param("roleId") Integer roleId);

    /**
     * 查询所有的菜单
     *
     * @return List<Menu>
     */
    List<Menu> findAllMenu();

    /**
     * 查询所有的菜单tree
     *
     * @return List<MenuTree>
     */
    List<MenuTree> findAllMenuTree();

    /**
     * 查询所有菜单标记角色的所有权限菜单
     *
     * @param roleId 角色ID
     * @return List<MenuTree>
     */
    List<MenuTree> findAllRoleMenuTree(Integer roleId);
}