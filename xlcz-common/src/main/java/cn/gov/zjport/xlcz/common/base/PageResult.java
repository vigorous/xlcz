/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.common.base;

import com.github.pagehelper.Page;

import java.io.Serializable;

/**
 * 分页结果集
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class PageResult<T> implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1262442449375444267L;
    /** 总数 */
    public Long total;
    /** 数据结果集 */
    public Object data;

    /**
     * 无参构造
     */
    public PageResult() {
    }

    /**
     * 构造
     *
     * @param page pagehelper的page分页
     */
    public PageResult(Page<T> page) {
        this.total = page.getTotal();
        this.data = page.getResult();
    }

    /**
     * @return the total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
}
