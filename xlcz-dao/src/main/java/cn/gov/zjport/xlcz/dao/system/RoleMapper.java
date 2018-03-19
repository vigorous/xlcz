package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 查询部门角色
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
}