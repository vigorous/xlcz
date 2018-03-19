package cn.gov.zjport.xlcz.webapp.controller.system;

import cn.gov.zjport.xlcz.common.context.Const;
import cn.gov.zjport.xlcz.domain.common.MenuJson;
import cn.gov.zjport.xlcz.domain.vo.Log;
import cn.gov.zjport.xlcz.domain.vo.Menu;
import cn.gov.zjport.xlcz.domain.vo.User;
import cn.gov.zjport.xlcz.service.system.log.LogService;
import cn.gov.zjport.xlcz.service.system.menu.MenuService;
import cn.gov.zjport.xlcz.service.system.user.UserService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 登陆控制器
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    /** 日志 */
    //private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /** 用户服务 */
    @Autowired
    private UserService userService;

    /** 菜单服务 */
    @Autowired
    private MenuService menuService;

    /** 日志服务 */
    @Autowired
    private LogService logService;

    /**
     * 登陆操作
     *
     * @return String
     */
    @RequestMapping(value = "/login")
    public String login(User user, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), SecureUtil.md5(user.getPassword()));
        try {
            subject.login(token);
            Session session = subject.getSession();
            //查询用户
            User u = userService.findByUserName(user.getUserName());

            //添加用户登陆日志
            Log log = new Log();
            log.setUserId(u.getId());
            log.setRoleId(u.getRoleId());
            log.setIp(session.getHost());
            log.setLoginTime(new Date());
            logService.addLog(log);

            //获取用户菜单权限
            List<Menu> menuList = new ArrayList<>();
            if (StringUtil.isNotEmpty(u.getRoleId().toString())) {
                menuList = menuService.findByRoleId(u.getRoleId());
            }

            //将有权限菜单列表转换成页面需要的菜单列表
            List<MenuJson> menuJsons = new ArrayList<>();
            for (Menu menu : menuList) {
                MenuJson mj = new MenuJson();
                mj.setId(menu.getId().toString());
                //子菜单才有pid的值
                if (menu.getPid() != null && menu.getPid() != 0) {
                    mj.setPid(menu.getPid().toString());
                }
                mj.setText(menu.getMenuName());
                mj.setUrl(menu.getMenuUri());
                menuJsons.add(mj);
            }

            //菜单列表转换成json
            String menuJson = JSON.toJSONString(menuJsons);
            LOGGER.info("menuJson:{}", menuJson);

            //将User对象、菜单权限保存到session中
            session.setAttribute(Const.SESSION_USER, u);
            session.setAttribute(Const.MENU_JSON, menuJson);

            //登录密码错误
        } catch (IncorrectCredentialsException e) {
            LOGGER.info("IncorrectCredentialsException...");
            String msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            request.setAttribute("msg", msg);
            return "login";
        } catch (UnknownAccountException e) {
            String msg = "帐号不存在!" + token.getPrincipal();
            request.setAttribute("msg", msg);
            return "login";
        } catch (DisabledAccountException e) {
            String msg = "帐号已被禁用! The account for username " + token.getPrincipal() + " was disabled.";
            request.setAttribute("msg", msg);
            return "login";
        }
        return "default";
        /*} catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            model.addAttribute("message", msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            model.addAttribute("message", msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            model.addAttribute("message", msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            model.addAttribute("message", msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            model.addAttribute("message", msg);
        } catch (UnknownAccountException e) {
            String msg = "帐号不存在!" + token.getPrincipal();
            model.addAttribute("message", msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            model.addAttribute("message", msg);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "failure");
            return "404";
        }*/
    }

    /**
     * 跳转到登陆页面
     *
     * @return String
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登出注销
     *
     * @return String
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        //设置session失效
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 初始页面
     *
     * @return String
     */
    @RequestMapping(value = "/default")
    public String index() {
        return "default";
    }
}
