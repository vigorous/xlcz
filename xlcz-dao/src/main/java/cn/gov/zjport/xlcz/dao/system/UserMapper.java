package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.dto.UserDto;
import cn.gov.zjport.xlcz.domain.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    /**
     * 分页查询
     *
     * @param userDto 用户
     * @return List<userDto>
     */
    List<UserDto> findByPage(UserDto userDto);

    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    List<User> selectAllUser();

    /**
     * 通过用户名查询用户信息
     *
     * @param userName 用户名
     * @return User
     */
    User selectByUserName(String userName);

    /**
     * 通过用户名查询角色名称
     *
     * @param userName 用户名
     * @return Set<String>
     */
    Set<String> getRole(String userName);

    /**
     * 逻辑删除
     *
     * @param id 用户ID
     * @return int
     */
    int deleteById(Integer id);

    /**
     * 通过主键查询用户信息Dto
     *
     * @param id 用户ID
     * @return User
     */
    UserDto findUserDtoById(@Param("id") Integer id);

}