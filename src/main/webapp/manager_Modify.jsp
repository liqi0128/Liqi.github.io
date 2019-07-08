<%@ page contentType="text/html; charset=utf-8"  %>
<script src="JS/manager.js" ></script>
<table width="292" height="175" border="0" cellpadding="0" cellspacing="0" background="Images/subBG.jpg">
    <tr>
        <td valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="3%" height="25">&nbsp;</td>
                    <td width="94%">&nbsp;</td>
                    <td width="3%">&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <table width="100%" height="131" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td align="center" valign="top">
                                    <form name="form1" id="modify" method="post">
                                        <table height="126" border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td width="85" height="29" align="center">管理员名称：</td>
                                                <td width="190">
                                                    <input name="id" id="id" type="hidden" value=" ">
                                                    <input name="name" id="name" type="text" readonly="yes" value=" ">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td height="74" align="center">拥有的权限：</td>
                                                <td>
                                                    <table width="100%" height="67" border="0" cellpadding="0"
                                                           cellspacing="0">
                                                        <tr>
                                                            <%--checked--%>
                                                            <td width="47%"><input name="sysset" type="checkbox"
                                                                                   class="noborder" id="sysset"
                                                                                   value="1" >
                                                                系统设置
                                                            </td>
                                                            <td width="53%"><input name="readerset" type="checkbox"
                                                                                   class="noborder" id="readerset"
                                                                                   value="1" >
                                                                读者管理
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><input name="bookset" type="checkbox" class="noborder"
                                                                       id="bookset"
                                                                       value="1" >
                                                                图书管理
                                                            </td>
                                                            <td><input name="borrowback" type="checkbox"
                                                                       class="noborder" id="borrowback"
                                                                       value="1" >
                                                                图书借还
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td height="23"><input name="sysquery" type="checkbox"
                                                                                   class="noborder" id="sysquery"
                                                                                   value="1" >
                                                                系统查询
                                                            </td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td height="22" align="center">&nbsp;</td>
                                                <td><input name="Button" type="button" onclick="PurviewModify()" class="btn_grey" value="保存">
                                                    &nbsp;
                                                    <input name="Submit2" type="button" class="btn_grey" value="关闭"
                                                           onClick="closeWindow()"></td>
                                            </tr>
                                        </table>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td height="17">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </td>
    </tr>
</table>


