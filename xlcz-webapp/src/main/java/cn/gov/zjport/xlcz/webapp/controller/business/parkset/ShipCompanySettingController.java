/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.business.parkset;

import cn.gov.zjport.xlcz.common.base.PageResult;
import cn.gov.zjport.xlcz.common.context.SystemContext;
import cn.gov.zjport.xlcz.common.utils.JSONUtil;
import cn.gov.zjport.xlcz.common.utils.PageUtil;
import cn.gov.zjport.xlcz.domain.so.ShipCompanySettingSo;
import cn.gov.zjport.xlcz.domain.vo.ShipCompanySetting;
import cn.gov.zjport.xlcz.service.business.ShipCompanySettingService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 船公司识别设置管理
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/ship")
public class ShipCompanySettingController extends BaseController {
    /** serialVersionUID */
    private static final long serialVersionUID = -826501936575965728L;

    /** 路劲前缀 */
    private static final String PREFIX = "business/parkset/shipcompanysetting/";

    /** 船公司识别设置服务 */
    @Autowired
    private ShipCompanySettingService shipCompanySettingService;

    /**
     * 船公司识别设置列表页面
     *
     * @return String
     */
    @RequestMapping(value = "/index")
    public String index() {
        return PREFIX + "shipset_list";
    }

    /**
     * 列表
     *
     * @param shipCompanySettingSo 船公司识别设置so
     * @return Object
     */
    @RequestMapping(value = "/shipSettingList")
    @ResponseBody
    public Object shipSettingList(ShipCompanySettingSo shipCompanySettingSo) {
        PageInfo<ShipCompanySetting> pageInfo = shipCompanySettingService.findByPage(shipCompanySettingSo);
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
        return PREFIX + "shipset_add";
    }

    /**
     * 新增
     *
     * @param shipCompanySetting 船公司识别设置
     * @return Object
     */
    @RequestMapping(value = "/addShip")
    @ResponseBody
    public Object addShip(ShipCompanySetting shipCompanySetting) {
        List<ShipCompanySetting> list = shipCompanySettingService.findByShippingCompany(shipCompanySetting);
        if (list != null && list.size() > 0) {
            return JSONUtil.jsonResult(SystemContext.CODE_SAME, "已有船公司:" + shipCompanySetting.getShippingCompany());
        }
        int i = shipCompanySettingService.insert(shipCompanySetting);
        if (i == 0) {
            return JSONUtil.jsonResult(SystemContext.SAVE_FAIL);
        }
        return JSONUtil.jsonResult(SystemContext.SAVE_SUCCESS);
    }

    /**
     * 修改页面
     *
     * @return String
     */
    @RequestMapping(value = "/toEdit")
    public String toEdit(ShipCompanySetting shipCompanySetting, HttpServletRequest request) {
        shipCompanySetting = shipCompanySettingService.findById(shipCompanySetting.getId());
        request.setAttribute("ship", shipCompanySetting);
        return PREFIX + "shipset_edit";
    }

    /**
     * 修改
     *
     * @param shipCompanySetting 船公司识别设置
     * @return Object
     */
    @RequestMapping(value = "/editShip")
    @ResponseBody
    public Object editShip(ShipCompanySetting shipCompanySetting) {
        shipCompanySetting.setModifyId(this.getSessionUserId());
        shipCompanySetting.setModifyTime(new Date());
        int i = shipCompanySettingService.update(shipCompanySetting);
        if (i == 0) {
            return JSONUtil.jsonResult(SystemContext.MODIFY_FAIL);
        }
        return JSONUtil.jsonResult(SystemContext.MODIFY_SUCCESS);
    }

    /**
     * 删除
     *
     * @param ids ID集合
     * @return String
     */
    @RequestMapping(value = "/delShips")
    @ResponseBody
    public String delDept(String[] ids) {
        try {
            shipCompanySettingService.batchDelete(ids);
        } catch (Exception e) {
            LOGGER.error(e.toString(), e);
            return JSONUtil.failJsonResult(e.getMessage());
        }
        return JSONUtil.jsonResult(SystemContext.DELETE_SUCCESS);
    }
}
