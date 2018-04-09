/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.system.dic;

import cn.gov.zjport.xlcz.domain.vo.Dic;
import cn.gov.zjport.xlcz.service.system.base.BaseService;

/**
 * 字典服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public interface DicService extends BaseService {
    /**
     * 通过字典代码查询字典
     *
     * @param dicCode 字典代码
     * @return Dic 字典
     */
    Dic findByDicCode(String dicCode);
}
