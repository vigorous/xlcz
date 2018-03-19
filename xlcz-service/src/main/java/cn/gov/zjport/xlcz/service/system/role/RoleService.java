package cn.gov.zjport.xlcz.service.system.role;

import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 角色服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface RoleService {
    /**
     * 通过角色ID查询角色信息
     *
     * @param id 角色ID
     * @return Role
     */
    Role findRoleById(Integer id);

    /**
     * 查询部门角色
     *
     * @param deptId 部门ID
     * @return List<RoleJo>
     */
    List<RoleJo> findByDeptId(Integer deptId);

    /**
     * 角色列表分页查询
     *
     * @param roleSo 角色查询so
     * @return PageInfo<Role>
     */
    PageInfo<Role> findByPage(RoleSo roleSo);
}
