package cn.gov.zjport.xlcz.webapp.controller.system.user;

import cn.gov.zjport.xlcz.domain.vo.User;
import cn.gov.zjport.xlcz.service.system.user.UserService;
import cn.gov.zjport.xlcz.webapp.base.BaseJunit4Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户服务单元测试
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class UserControllerTest extends BaseJunit4Test {

    /** 用户服务 */
    @Autowired
    private UserService userService;

    /**
     * 新增用户
     */
    @Test
    public void addUser() {
        System.out.println("...");
        User user = new User();
        user.setPassword("11");
        user.setUserName("李四3");
        user.setName("李四");
        int i = userService.insert(user);
        System.out.println("i = " + i);
    }
}