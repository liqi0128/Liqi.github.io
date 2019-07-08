<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>

<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<script src="JS/pwdModify.js"></script>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：更改口令 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="84%">&nbsp;      </td>
</tr>
</table>  <form name="form1" method="post" >
  <table width="47%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#D2E3E6" bordercolorlight="#FFFFFF">
  <tr align="center">
    <td width="27%" align="left" style="padding:5px;">管理员名称：</td>
    <td width="73%" align="left">
      <input name="name" type="text" id="name" value="${manager.name}" readonly="yes" size="30"/>    </td>
    <tr>
    <td align="left" style="padding:5px;">原密码：</td>
    <td align="left"><input name="oldpwd" type="password" onchange="pwdold1()" id="oldpwd" size="30"/><span style="color: red" id="erro"></span>

    </tr>
    <tr>
      <td align="left" style="padding:5px;">新密码：</td>
      <td align="left"><input name="pwd" type="password" id="pwd" size="30"/></td>
    </tr>
    <tr>
      <td align="left" style="padding:5px;">确认新密码：</td>
      <td align="left"><input name="pwd1" type="password" id="pwd1" size="30"/></td>
    </tr>
    <tr>
      <td height="65" align="left" style="padding:5px;">&nbsp;</td>
      <td><input name="Submit" type="button" class="btn_grey" value="保存" onClick="pwdModify()"/>
        &nbsp;
        <input name="Submit2" type="reset" class="btn_grey" value="取消"/></td>
    </tr>
</table>
</form></td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
</body>
<script>

</script>
</html>
