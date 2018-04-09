/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/

/** 重置 */
function reset() {
    mini.get("entryId").setValue('');
    mini.get("billNo").setValue('');
    mini.get("containerNos").setValue('');
}

/** 校验集装箱号 */
function checkContainerNo(containerNo) {
    //长度不为11
    if (containerNo.length != 11) {
        return false;
    }
    //前4位为字母，后七位为数字
    var regExp = /^[A-Za-z]{4}[0-9]{7}$/;
    if (!regExp.test(containerNo)) {
        return false;
    }
}

/** 查验作业录入 */
function addCheckWork() {
    //校验表单数据
    var form = new mini.Form("#addForm");
    var flag = form.validate();
    if (!flag) {
        return;
    }
    var data = form.getData();

    //校验集装箱号
    var containerNos = mini.get('containerNos').getValue();
    var con = containerNos.split('\n');
    var errContainerArr = new Array();
    var submitFlag = true;
    for (var i = 0; i < con.length; i++) {
        if (con[i] == null || con[i] == '') {
            continue;
        }
        if (!checkContainerNo(con[i])) {
            errContainerArr.push(con[i]);
            submitFlag = false;
        }
    }

    //集装箱号有误提示信息
    if (!submitFlag) {
        var msg = "以下集装箱号不正确:<br/>";
        for (var i = 0; i < errContainerArr.length; i++) {
            msg += errContainerArr[i] + "<br/>";
        }
        showMsgBox('提示', msg, 'fail');
    }

    //新增查验作业信息
    $.ajax({
        url: _G.baseUrl + "/checkworkEnter/addCheckWork.do",
        data: data,
        type: "post",
        success: function (data) {
            data = mini.decode(data);
            if (data == 0) {
                showMsgBox('新增', data.message, 'fail');
            } else {
                showMsgBox('新增', data.message, 'success', function () {
                    closeWindow();
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    });
}