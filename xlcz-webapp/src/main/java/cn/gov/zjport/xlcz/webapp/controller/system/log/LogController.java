/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.webapp.controller.system.log;

import cn.gov.zjport.xlcz.common.base.PageResult;
import cn.gov.zjport.xlcz.common.utils.PageUtil;
import cn.gov.zjport.xlcz.domain.dto.LogDto;
import cn.gov.zjport.xlcz.service.system.log.LogService;
import cn.gov.zjport.xlcz.webapp.controller.base.BaseController;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志控制器
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

    /** 日志服务 */
    @Autowired
    private LogService logService;

    /**
     * 日志列表首页
     *
     * @return String
     */
    @RequestMapping(value = "/index")
    public String index() {
        LOGGER.info("日志首页...");
        return "system/log/log_list";
    }

    /**
     * 日志列表
     *
     * @param logDto 日志对象
     * @return String
     */
    @RequestMapping(value = "/logList")
    @ResponseBody
    public String logList(LogDto logDto) {
        PageInfo<LogDto> pageInfo = logService.findByPage(logDto);
        PageResult result = PageUtil.getPageResult(pageInfo.getTotal(), pageInfo.getList());
        return JSON.toJSONString(result);
    }

    /**
     * 导出
     *
     * @return String
     */
    @RequestMapping(value = "/excel")
    @ResponseBody
    public void excel(LogDto logDto, HttpServletResponse response) {

        try {
            ArrayList<Map<String, Object>> rows = CollUtil.newArrayList();

            List<LogDto> list = logService.findByCondition(logDto);

            for (LogDto log : list) {
                Map<String, Object> row = new LinkedHashMap<>();
                row.put("用户名称", log.getUserName());
                row.put("姓名", log.getName());
                row.put("角色名称", log.getRoleName());
                row.put("IP地址", log.getIp());
                row.put("登录日期", log.getLoginTime());
                rows.add(row);
            }

            String fileName = "日志log" + String.valueOf(System.currentTimeMillis()) + ".xls";

            // 通过工具类创建writer
            ExcelWriter writer = ExcelUtil.getWriter();
            // 合并单元格后的标题行，使用默认标题样式
            //writer.merge(row1.size() - 1, "一班成绩单");
            // 一次性写出内容，使用默认样式
            response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/vnd.ms-excel");
            OutputStream ouputStream = response.getOutputStream();
            writer.write(rows);
            writer.flush(ouputStream);
            // 关闭writer，释放内存
            writer.close();
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
    }

}
