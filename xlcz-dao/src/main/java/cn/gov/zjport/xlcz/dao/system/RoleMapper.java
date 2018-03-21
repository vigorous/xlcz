package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;

import java.util.List;

public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

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
    List<RoleJo> findByDeptId(Integer detpId);

    /**
     * 角色列表分页查询
     *
     * @param roleSo 角色查询so
     * @return List<Role>
     */
    List<Role> findByPage(RoleSo roleSo);
}