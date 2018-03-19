/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/

/** 登出 */
function logout() {
    parent.mini.showMessageBox({
        title: '登出',
        buttons: ["ok", "cancel"],
        html: '<div class="messageBox"><img src="../images/mark.png"/><span>你确定要退出吗?</span></div>',
        callback: function (action) {
            if (action == 'ok') { //删除
                $.ajax({
                    url: _G.baseUrl + "/login/logout.do",
                    success: function (text) {

                    },
                    error: function () {
                    }
                });
            }
        }
    });
}