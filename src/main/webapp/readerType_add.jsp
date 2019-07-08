<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<script language="jscript">
function check(form){
	if(form.name.value==""){
		alert("请输入类型名称!");form.name.focus();return false;
	}
	if(form.number.value==""){
		alert("请输入可借数量!");form.number.focus();return false;
	}	
}
</script>

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
            <td align="center">	<form name="form1" method="post" id="readerTypeAdd">
	<table height="100"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="84" align="center">类型名称：</td>
        <td width="191" height="39">
          <input name="name" type="text" size="28" id="name">        </td>
      </tr>
      <tr>
        <td width="84" align="center">可借数量：</td>
        <td height="35"><input name="number" type="text" id="number">
          (本)</td>
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


