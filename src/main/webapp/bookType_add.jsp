<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<table width="292" height="175" border="0" cellpadding="0" cellspacing="0" background="Images/subBG.jpg">
  <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="3%" height="31">&nbsp;</td>
        <td width="94%">&nbsp;</td>
        <td width="3%">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><table width="100%" height="131"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center">	<form name="form1" method="post" id="bookTypeAdd">
	<table height="100"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="77" align="center">类型名称：</td>
        <td width="198" height="39">
          <input name="typename" type="text" size="30">        </td>
      </tr>
      <tr>
        <td width="77" align="center">可借天数：</td>
        <td height="35"><input name="days" type="text" id="days" size="25">
          (天)</td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
        <td><input name="Submit" type="button" class="btn_grey" value="保存" onClick="add()">
          &nbsp;
          <input name="Submit2" type="button" class="btn_grey" value="关闭" onClick="closeWindow();"></td>
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

