package cn.gov.zjport.xlcz.service.system.role;

import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;
import cn.gov.zjport.xlcz.service.system.base.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 角色服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface RoleService extends BaseService {
    /**
     * 通过角色ID查询角色信息
     *
     * @param id 角色ID
     * @return Role
     */
    Role findRoleById(Integer id);

    /**
     * 查询部门所有角色
     *
     * @param deptId 部门ID
     * @return List<Role>
     */
    List<Role> findRolesByDeptId(Integer deptId);

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

    /**
     * 新增角色和角色菜单权限
     *
     * @param role 角色
     */
    void insertRoleAndAuth(Role role) throws Exception;

    /**
     * 修改角色和角色菜单权限
     *
     * @param role 角色
     */
    void updateRoleAuth(Role role);

    /**
     * 逻辑删除角色
     *
     * @param ids 角色ID集合
     */
    void deleteByIds(String[] ids);
}
