package cn.gov.zjport.xlcz.service.system.user;

import cn.gov.zjport.xlcz.domain.dto.UserDto;
import cn.gov.zjport.xlcz.domain.vo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Set;

/**
 * 用户服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface UserService {

    /**
     * 分页查询
     *
     * @param userDto 用户
     * @return PageInfo<UserDto>
     */
    PageInfo<UserDto> findByPage(UserDto userDto);

    /**
     * 查询所有的用户信息
     *
     * @return List<User>
     */
    List<User> findAllUser();

    /**
     * 通过主键查询用户信息
     *
     * @param id 用户ID
     * @return User
     */
    User findUserById(Integer id);

    /**
     * 通过主键查询用户信息Dto
     *
     * @param id 用户ID
     * @return User
     */
    UserDto findUserDtoById(Integer id);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名称
     * @return User
     */
    User findByUserName(String userName);

    /**
     * 通过用户名查询角色名称
     *
     * @param userName 用户名
     * @return Set<String>
     */
    Set<String> getRoleByUserName(String userName);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return int
     */
    int deleteById(Integer id);

    /**
     * 批量删除用户
     *
     * @param ids 用户集合
     */
    void batchDeleteById(String[] ids);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return int
     */
    int insert(User user);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return int
     */
    int update(User user);
}
