/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/


/**
 * 全局设置ajax访问的complete方法
 * @type {string}
 */
var timeoutlogin = _G.baseUrl + "/login/toLogin.do";
$.ajaxSetup({
    contentType: "application/x-www-form-urlencoded;charset=utf-8",
    cache: false,
    complete: function (data, TS) {
        //对返回的数据data做判断
        console.log("ajaxSetup data --> ", data);
        //403是后台拦截器那儿定义的，
        if (data.status == 403) {
            //session过期的话，就location到一个页面
            debugger;
            window.top.location.href = timeoutlogin;
            return;
        }
    }
});

/**
 * 显示提示框
 * @param title 弹窗标题
 * @param message 提示信息
 * @param messageType 提示信息类型（success:成功提示,fail:失败提示,mark:默认提示）
 * @param callback 回调函数
 */
function showMsgBox(title, message, messageType, callback) {
    var divHtml = '<div class="messageBox"><img src="../images/mark.png"/><span>' + message + '</span></div>';
    if (messageType == 'success') {
        divHtml = '<div class="messageBox"><img src="../images/success.png"/><span>' + message + '</span></div>';
    } else if (messageType == 'fail') {
        divHtml = '<div class="messageBox"><img src="../images/fail.png"/><span>' + message + '</span></div>';
    } else if (messageType == 'mark') {
        divHtml = '<div class="messageBox"><img src="../images/mark.png"/><span>' + message + '</span></div>';
    }
    parent.mini.showMessageBox({
        title: title,
        buttons: ["ok", "cancel"],
        html: divHtml,
        callback: callback
    });
}


/** 关闭弹窗 */
function closeWindow() {
    window.CloseOwnerWindow("cancel");
}

function createMenu(id, menuName) {
    var menu = new Object;
    menu.id = id;
    menu.menuName = menuName;
    return menu;
}