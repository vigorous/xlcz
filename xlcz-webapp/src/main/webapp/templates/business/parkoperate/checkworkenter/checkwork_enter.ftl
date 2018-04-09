<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>>报关单/集装箱补录</title>
    <#include "../../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">园区操作&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">报关单/集装箱补录</a>
    </div>
    <div class="main">
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="表单">
                    <form id="form1" class="form">
                        <div class="single-form margin-top-1">
                            <table class="form-all form-error" border="0" cellspacing="1" cellpadding="0">
                                <tr>
                                    <td width="15%">
                                        <div class="form-label">报关单号</div>
                                    </td>
                                    <td width="85%" class="single-form-input">
                                        <div class="mini-col-4">
                                            <div class="form-input">
                                                <input id="entryId" class="mini-textbox" name="entryId" height="30"
                                                       emptyText="请输入报关单号"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="15%">
                                        <div class="form-label">提单编号</div>
                                    </td>
                                    <td width="85%" class="single-form-input">
                                        <div class="mini-col-4">
                                            <div class="form-input">
                                                <input id="billNo" class="mini-textbox" name="billNo" height="30"
                                                       emptyText="请输入提单编号"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="15%">
                                        <div class="form-label">集装箱号</div>
                                    </td>
                                    <td width="85%" class="single-form-input">
                                        <div class="mini-col-4">
                                            <div class="form-input">
                                                <input id="containerNos" class="mini-textarea" name="containerNos"
                                                       height="80" emptyText="请输入集装箱号（换行隔开）" required/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                            <div>
                                <div class="button-group-form">
                                    <input class="btn" type="button" value="确定" onclick="addCheckWork()"/>
                                    <input class="btn-primary" type="button" value="取消" onclick="reset()"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${baseUrl}/scripts/lib/jquery/jquery.min.js"></script>
<script src="${baseUrl}/scripts/lib/miniui/miniui.js"></script>
<script src="${baseUrl}/scripts/lib/miniui/fixheight.js"></script>
<script src="${baseUrl}/scripts/common/form.js"></script>
<script src="${baseUrl}/scripts/system/common/zjport.js"></script>
<script src="${baseUrl}/scripts/business/parkoperate/checkwork_enter.js"></script>
<script>
    mini.parse();
</script>
</body>

</html>