package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    /**
     * 物理删除
     *
     * @param id 角色ID
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 选择新增
     *
     * @param role
     * @return
     */
    int insertSelective(Role role);

    /**
     * 根据主键查询角色
     *
     * @param id 角色ID
     * @return Role
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param role
     * @return
     */
    int updateByPrimaryKeySelective(Role role);

    /**
     * 查询部门所有角色
     *
     * @param deptId 部门ID
     * @return List<Role>
     */
    List<Role> findRolesByDeptId(Integer deptId);

    /**
     * 查询部门角色RoleJo对象
     *
     * @param detpId 部门ID
     * @return List<RoleJo>
     */
    List<RoleJo> findByDeptId(@Param("deptId") Integer detpId);

    /**
     * 角色列表分页查询
     *
     * @param roleSo 角色查询so
     * @return List<Role>
     */
    List<Role> findByPage(RoleSo roleSo);

    /**
     * 删除角色
     *
     * @param id 角色ID
     * @return int
     */
    int deleteById(Integer id);
}