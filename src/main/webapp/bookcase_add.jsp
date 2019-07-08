<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<table width="292" height="175" border="0" cellpadding="0" cellspacing="0" background="Images/subBG.jpg">
  <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="3%" height="25">&nbsp;</td>
        <td width="94%">&nbsp;</td>
        <td width="3%">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><table width="100%" height="131"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center" valign="top"><form name="form1" method="post" id="bookcaseAdd">
                <table width="100%" height="114"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="74" align="center">书架名称：
                      <input name="name" type="text"></td>
                    </tr>
                  <tr>
                    <td align="center"><input name="Submit3" type="button" onclick="add()" class="btn_grey" value="保存">
                      &nbsp;
                      <input name="Submit22" type="button" class="btn_grey" value="关闭" onClick="closeWindow()"></td>
                    </tr>
                </table>
            </form></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
