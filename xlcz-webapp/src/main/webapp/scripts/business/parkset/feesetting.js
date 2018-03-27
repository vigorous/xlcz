/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/

/** 刷新 */
function reload() {
    grid.load();
}

/** 保存 */
function save() {
    var data = grid.getChanges();
    //无数据修改直接返回
    if (data.length == 0) {
        return;
    }
    var json = mini.encode(data);
    // console.log("json = " + json);
    $.ajax({
        url: _G.baseUrl + "/feesetting/updateFeeSettings.do",
        data: {feeSettingJson: json},
        type: "post",
        success: function (data) {
            data = mini.decode(data);
            if (data.code == 0) {
                showMsgBox('修改', data.message, 'fail');
            } else {
                showMsgBox('修改', data.message, 'success', function () {
                    grid.reload();
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    });
}


function isFloat(value) {
    var reg = /^\d{1,11}?(\.\d{1,2})?$/;  //验证浮点数
    var regExp = new RegExp(reg);
    if (!regExp.test(value)) {
        alert('值不正确');
        //$('#feeValue').focus();
        mini.get('feeValue').focus;
        return false;
    }
}