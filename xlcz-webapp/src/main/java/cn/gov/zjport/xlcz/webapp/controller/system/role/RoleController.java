/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.system.role;

import cn.gov.zjport.xlcz.common.base.PageResult;
import cn.gov.zjport.xlcz.common.context.Const;
import cn.gov.zjport.xlcz.common.utils.JSONUtil;
import cn.gov.zjport.xlcz.common.utils.PageUtil;
import cn.gov.zjport.xlcz.domain.json.RoleJo;
import cn.gov.zjport.xlcz.domain.so.RoleSo;
import cn.gov.zjport.xlcz.domain.vo.Role;
import cn.gov.zjport.xlcz.service.system.role.RoleService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 角色管理
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    /** 角色服务 */
    @Autowired
    private RoleService roleService;

    /**
     * 角色下拉框
     *
     * @return String
     */
    @RequestMapping(value = "/roleJson")
    @ResponseBody
    public String roleJson(Integer deptId) {
        List<RoleJo> list = roleService.findByDeptId(deptId);
        return JSONUtil.jsonResult(Const.CODE_SUCCESS, Const.SUCCESS_DESC, list);
    }

    /**
     * 角色列表首页
     *
     * @return String
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "system/role/role_list";
    }

    /**
     * 角色列表
     *
     * @param roleSo 角色查询so
     * @return Object
     */
    @RequestMapping(value = "/roleList")
    @ResponseBody
    public Object roleList(RoleSo roleSo) {
        PageInfo<Role> pageInfo = roleService.findByPage(roleSo);
        PageResult pageResult = PageUtil.getPageResult(pageInfo);
        return JSON.toJSONString(pageResult);
    }

    /**
     * 新增页面
     *
     * @return String
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "system/role/role_add";
    }

    /**
     * 新增
     *
     * @param role 角色对象
     * @return Object
     */
    @RequestMapping(value = "/addRole")
    @ResponseBody
    public Object addRole(Role role) {
        return "";
    }

    /**
     * 编辑页面
     *
     * @param role 角色对象
     * @return String
     */
    @RequestMapping(value = "/toEdit")
    public String toEdit(Role role, HttpServletRequest request) {
        if (role.getId() != null) {
            role = roleService.findRoleById(role.getId());
        }
        request.setAttribute("r", role);
        return "system/role/role_edit";
    }

    /**
     * 编辑
     *
     * @param role 角色对象
     * @return Object
     */
    @RequestMapping(value = "/editRole")
    @ResponseBody
    public Object editRole(Role role) {
        return "";
    }
}
