/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.service.business.impl;

import cn.gov.zjport.xlcz.common.context.Const;
import cn.gov.zjport.xlcz.dao.business.CheckWorkEnterMapper;
import cn.gov.zjport.xlcz.dao.business.CheckWorkFeeMapper;
import cn.gov.zjport.xlcz.dao.business.CheckWorkInfoMapper;
import cn.gov.zjport.xlcz.domain.vo.CheckWorkEnter;
import cn.gov.zjport.xlcz.domain.vo.CheckWorkFee;
import cn.gov.zjport.xlcz.domain.vo.CheckWorkInfo;
import cn.gov.zjport.xlcz.service.business.CheckWorkEnterService;
import cn.gov.zjport.xlcz.service.system.base.impl.BaseServiceImpl;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 查验作业录入服务
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
@Service
public class CheckWorkEnterServiceImpl extends BaseServiceImpl implements CheckWorkEnterService {

    /** 查验作业录入mapper */
    @Resource
    private CheckWorkEnterMapper checkWorkEnterMapper;

    /** 查验作业信息mapper */
    @Resource
    private CheckWorkInfoMapper checkWorkInfoMapper;

    /** 查验作业费用mapper */
    @Resource
    private CheckWorkFeeMapper checkWorkFeeMapper;

    /**
     * 批量录入
     *
     * @param checkWorkEnter 查验作业录入记录信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchInsert(CheckWorkEnter checkWorkEnter) {
        //1.处理数据（每个集装箱号组成一条记录）
        String containerNos = checkWorkEnter.getContainerNos();
        String[] containerNoArr = containerNos.split(Const.CONTAINER_NO_SEPARATER);

        //报关单号
        String entryId = checkWorkEnter.getEntryId();
        //提单编号
        String billNo = checkWorkEnter.getBillNo();
        //登陆用户ID
        Integer userId = this.getSessionUserId();
        //当前时间
        Date currentDate = new Date();

        //2.批量插入查验作业录入信息（CheckWorkEnter）和查验作业信息（CheckWorkInfo）
        for (String containerNo : containerNoArr) {
            if (StrUtil.isBlank(containerNo)) {
                continue;
            }
            //插入查验作业录入记录（CheckWorkEnter）
            CheckWorkEnter cwe = new CheckWorkEnter();
            cwe.setEntryId(entryId);
            cwe.setBillNo(billNo);
            cwe.setContainerNo(containerNo);
            cwe.setCreateId(userId);
            cwe.setCreateTime(currentDate);
            checkWorkEnterMapper.insert(cwe);

            //插入查验作业信息记录（CheckWorkInfo）
            CheckWorkInfo checkWorkInfo = new CheckWorkInfo();
            checkWorkInfo.setEntryId(checkWorkEnter.getEntryId());
            checkWorkInfo.setBillNo(checkWorkEnter.getBillNo());
            checkWorkInfo.setContainerNo(containerNo);
            checkWorkInfo.setCreateId(userId);
            checkWorkInfo.setCreateTime(currentDate);
            checkWorkInfoMapper.insert(checkWorkInfo);

            //生成费用信息
            CheckWorkFee checkWorkFee = new CheckWorkFee();
            checkWorkFee.setCreateId(userId);
            checkWorkFee.setCreateTime(currentDate);
            checkWorkFeeMapper.insert(checkWorkFee);

            //设置查验作业的费用ID
            CheckWorkInfo cwi = new CheckWorkInfo();
            cwi.setId(checkWorkInfo.getId());
            cwi.setFeeId(checkWorkFee.getId());
            cwi.setModifyId(userId);
            cwi.setModifyTime(new Date());
            checkWorkInfoMapper.updateById(cwi);
        }
    }
}
