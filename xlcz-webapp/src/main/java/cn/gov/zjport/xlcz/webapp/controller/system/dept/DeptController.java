/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.system.dept;

import cn.gov.zjport.xlcz.common.base.PageResult;
import cn.gov.zjport.xlcz.common.context.SystemContext;
import cn.gov.zjport.xlcz.common.utils.JSONUtil;
import cn.gov.zjport.xlcz.common.utils.SystemUtil;
import cn.gov.zjport.xlcz.domain.json.DeptJo;
import cn.gov.zjport.xlcz.domain.vo.Dept;
import cn.gov.zjport.xlcz.domain.vo.User;
import cn.gov.zjport.xlcz.service.system.dept.DeptService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 部门控制
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {
    /** serialVersionUID */
    private static final long serialVersionUID = -6263097575656302707L;

    /** 部门服务 */
    @Autowired
    private DeptService deptService;

    /**
     * 部门列表首页
     *
     * @return String
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "system/dept/dept_list";
    }

    /**
     * 部门列表
     *
     * @param dept 部门对象
     * @return String
     */
    @RequestMapping(value = "/deptList")
    @ResponseBody
    public String deptList(Dept dept) {
        PageInfo<Dept> pageInfo = deptService.findByPage(dept);
        PageResult result = new PageResult();
        result.setTotal(pageInfo.getTotal());
        result.setData(pageInfo.getList());
        return JSON.toJSONString(result);
    }

    /**
     * 编辑页面
     *
     * @param dept    部门信息
     * @param request request
     * @return String
     */
    @RequestMapping(value = "/toEdit")
    public String toEdit(Dept dept, HttpServletRequest request) {
        if (dept.getId() != null) {
            dept = deptService.findById(dept.getId());
        }
        request.setAttribute("dpt", dept);
        return "system/dept/dept_edit";
    }

    /**
     * 修改部门
     *
     * @param dept 部门对象
     * @return String
     */
    @RequestMapping(value = "/editDept")
    @ResponseBody
    public String editDept(Dept dept) {
        if (dept.getId() != null) {
            int i = deptService.updateById(dept);
            if (i == 1) {
                return JSONUtil.jsonResult(SystemContext.MODIFY_SUCCESS);
            } else {
                return JSONUtil.jsonResult(SystemContext.MODIFY_FAIL);
            }
        } else {
            return JSONUtil.jsonResult(SystemContext.MODIFY_FAIL);
        }
    }

    /**
     * 新增页面
     *
     * @return String
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "system/dept/dept_add";
    }

    /**
     * 新增部门
     *
     * @return String
     */
    @RequestMapping(value = "/addDept")
    @ResponseBody
    public String addDept(HttpSession session, Dept dept) {
        //查询部门名称是否存在
        List<Dept> list = deptService.findByDeptName(dept);
        if (list != null && list.size() > 0) {
            return JSONUtil.jsonResult(SystemContext.CODE_SAME, "部门名称已存在");
        }
        User user = (User) SystemUtil.getSessionUser();
        dept.setCreateId(user.getId());
        dept.setCreateTime(new Date());
        //保存部门
        int i = deptService.insertSelective(dept);
        if (i != 1) {
            return JSONUtil.jsonResult(SystemContext.SAVE_FAIL);
        }
        return JSONUtil.jsonResult(SystemContext.SAVE_SUCCESS);
    }

    /**
     * 删除部门
     *
     * @param ids 部门ID集合
     * @return String
     */
    @RequestMapping(value = "/delDept")
    @ResponseBody
    public String delDept(String[] ids) {
        int i = deptService.deleteById(ids);
        return JSONUtil.jsonResult(SystemContext.DELETE_SUCCESS);
    }

    /**
     * 部门下拉框
     *
     * @return String
     */
    @RequestMapping(value = "/deptJson")
    @ResponseBody
    public String deptJson() {
        List<DeptJo> list = deptService.findAll();
        return JSONUtil.jsonResult(1, "成功", list);
    }
}
