/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.system.user;

import cn.gov.zjport.xlcz.common.base.PageResult;
import cn.gov.zjport.xlcz.common.context.SystemContext;
import cn.gov.zjport.xlcz.common.utils.JSONUtil;
import cn.gov.zjport.xlcz.common.utils.PageUtil;
import cn.gov.zjport.xlcz.domain.dto.UserDto;
import cn.gov.zjport.xlcz.domain.vo.User;
import cn.gov.zjport.xlcz.service.system.user.UserService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 用户管理
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    /** 用户服务 */
    @Autowired
    private UserService userService;

    /**
     * 用户首页
     *
     * @return String
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "system/user/user_list";
    }

    /**
     * 用户列表
     *
     * @param userDto 用户
     * @return String
     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    public String userList(UserDto userDto) {
        PageInfo<UserDto> pageInfo = userService.findByPage(userDto);
        PageResult result = PageUtil.getPageResult(pageInfo.getTotal(), pageInfo.getList());
        return JSON.toJSONString(result);
    }

    /**
     * 新增页面
     *
     * @return String
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "system/user/user_add";
    }

    /**
     * 新增
     *
     * @param user 用户
     * @return String
     */
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUser(User user) {
        //新增用户信息
        if (user == null) {
            return JSONUtil.jsonResult(SystemContext.MessageType.SAVE_FAIL.getValue());
        }
        if (StrUtil.isNotBlank(user.getPassword())) {
            user.setPassword(SecureUtil.md5(user.getPassword()));
        }
        User sessionUser = this.getSessionUser();
        user.setCreateId(sessionUser.getId());
        user.setCreateTime(new Date());
        int i = userService.insert(user);
        if (i != 1) {
            return JSONUtil.jsonResult(SystemContext.MessageType.SAVE_FAIL.getValue());
        }
        return JSONUtil.jsonResult(SystemContext.MessageType.SAVE_SUCCESS.getValue());
    }

    /**
     * 编辑页面
     *
     * @param userDto 用户
     * @param request request
     * @return String
     */
    @RequestMapping(value = "/toEdit")
    public String toEdit(UserDto userDto, HttpServletRequest request) {
        if (userDto.getId() != null) {
            userDto = userService.findUserDtoById(userDto.getId());
        }
        request.setAttribute("u", userDto);
        return "system/user/user_edit";
    }

    /**
     * 修改
     *
     * @param user 用户
     * @return String
     */
    @RequestMapping(value = "/editUser")
    @ResponseBody
    public String editUser(User user) {
        if (user == null) {
            return JSONUtil.jsonResult(SystemContext.MessageType.MODIFY_FAIL.getValue());
        }
        if (StrUtil.isNotBlank(user.getPassword())) {
            user.setPassword(SecureUtil.md5(user.getPassword()));
        }
        user.setModifyId(this.getSessionUserId());
        user.setModifyTime(new Date());
        int i = userService.update(user);
        return JSONUtil.jsonResult(SystemContext.MessageType.MODIFY_SUCCESS.getValue());
    }

    /**
     * 删除
     *
     * @param userDto 用户
     * @return String
     */
    @RequestMapping(value = "/delUser")
    @ResponseBody
    public String delUser(UserDto userDto) {
        if (userDto != null) {
            userService.deleteById(userDto.getId());
        }
        return JSONUtil.jsonResult("");
    }

    /**
     * 批量删除
     *
     * @param ids 用户集合
     * @return String
     */
    @RequestMapping(value = "/delUsers")
    @ResponseBody
    public String delUsers(String[] ids) {
        userService.batchDeleteById(ids);
        return JSONUtil.jsonResult("");
    }


}
