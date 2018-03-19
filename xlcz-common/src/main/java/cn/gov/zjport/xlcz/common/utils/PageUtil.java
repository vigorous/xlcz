/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.common.utils;

import cn.gov.zjport.xlcz.common.base.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * 分页工具类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class PageUtil {

    /**
     * 获取分页结果数据
     *
     * @param total  总数
     * @param object 数据
     * @return PageResult
     */
    public static PageResult getPageResult(Long total, Object object) {
        PageResult result = new PageResult();
        result.setTotal(total);
        result.setData(object);
        return result;
    }

    /**
     * 获取分页结果数据对象
     *
     * @param pageInfo 对Page<E>结果进行包装
     * @return PageResult
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setData(pageInfo.getList());
        return pageResult;
    }
}
