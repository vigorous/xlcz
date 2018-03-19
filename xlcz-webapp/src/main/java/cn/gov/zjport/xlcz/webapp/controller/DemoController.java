/**************************************************************************
 * Copyright (c) 2006-2015 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：区域大通关系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller;

import cn.gov.zjport.xlcz.common.base.DefaultController;
import cn.gov.zjport.xlcz.common.base.BaseResult;
import cn.gov.zjport.xlcz.service.system.user.UserService;
import cn.gov.zjport.xlcz.domain.vo.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * ${desc}
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends DefaultController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/json")
    @ResponseBody
    public String demo() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setUserName("张珊");
        user.setPassword("123456");

        User user1 = new User();
        user1.setId(2);
        user1.setUserName("lisi");
        user1.setPassword("123321");

        list.add(user);
        list.add(user1);

        /*User u = userService.findUserById(3);
        if (u != null) {
            list.add(u);
        }*/
        List<User> ls = userService.findAllUser();
        if (ls != null && ls.size() > 0) {
            list.addAll(ls);
            for (User u : ls) {
                System.out.println(u.toString());
            }
        }


        BaseResult baseResult = new BaseResult(1, "成功", list);

        String resultStr = JSON.toJSONString(baseResult);


        return resultStr;
    }

    @RequestMapping("/listUser")
    public String listUser(HttpServletRequest request) {
        request.setAttribute("users",userService.findAllUser());
        return "system/list";
    }


}
