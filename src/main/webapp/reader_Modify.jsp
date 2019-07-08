<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%@ page import="java.util.*"%>
<html>

<script language="jscript">

</script>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>

<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<script src="JS/readerModify.js"></script>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：读者管理 &gt; 读者档案管理 &gt; 修改读者信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>

    <td align="center" valign="top">
	<form name="form1" method="post"id="readerModify">
	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="173" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
        <td width="427" height="39">
          <input name="name" type="text" value="${reader.name}" readonly="yes">
          *         
          <input name="id" type="hidden" id="id" value="${reader.id}"></td>
      </tr>
      <tr>
        <td width="173" align="center">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td><%--checked--%>
          <td height="35"><input name="sex" type="radio" class="noborder" id="radiobutton" value="男" <c:if test="${reader.sex eq '男'}">checked</c:if> >
          <label for="radiobutton">男 </label>
          <label>
          <input name="sex" type="radio" class="noborder" value="女" <c:if test="${reader.sex eq '女'}">checked</c:if> >
          女</label></td>
      </tr>
      <tr>
        <td align="center">条&nbsp;形&nbsp;码：</td>
        <td><input name="barcode" type="text" id="barcode" value="${reader.barcode}" readonly="yes"></td>
      </tr>
      <tr>
        <td align="center">读者类型：</td>
        <td>
		<select name="typeid" class="wenbenkuang" id="typeid" typeid="${reader.typeid}"><%--selected--%>

				


        </select>        </td>
      </tr>
      <tr>
        <td align="center">职&nbsp;&nbsp;&nbsp;&nbsp;业：</td>
        <td><input name="vocation" type="text" id="vocation" value="${reader.vocation}"></td>
      </tr>
      <tr>
        <td align="center">出生日期：</td>
        <td><input name="birthday" type="date" id="birthday" value="${reader.birthday}"></td>
      </tr>
      <tr>
        <td align="center">有效证件：</td>
        <td><select name="paperType" class="wenbenkuang" id="paperType">
            <option value="身份证" <c:if test="${reader.paperType eq '身份证'}">selected</c:if> >身份证</option>
          <option value="学生证" <c:if test="${reader.paperType eq '学生证'}">selected</c:if> >学生证</option>
          <option value="军官证" <c:if test="${reader.paperType eq '军官证'}">selected</c:if> >军官证</option>
          <option value="工作证" <c:if test="${reader.paperType eq '工作证'}">selected</c:if> >工作证</option>
                        </select></td>
      </tr>
      <tr>
        <td align="center">证件号码：</td>
        <td><input name="paperNO" type="text" id="paperNO" value="${reader.paperNO}">
          * </td>
      </tr>
      <tr>
        <td align="center">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
        <td><input name="tel" type="text" id="tel" value="${reader.tel}"></td>
      </tr>
      <tr>
        <td align="center">Email：</td>
        <td><input name="email" type="text" id="email" value="${reader.email}" size="50">
          </td>
      </tr>
      <tr>
        <td height="30" align="center">操&nbsp;作&nbsp;员：</td>
        <td><input name="operator" type="text" id="operator" value="${reader.operator}" readonly="yes">
        </td>
      </tr>
      <tr>
        <td align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
        <td><textarea name="remark" cols="50" rows="5" class="wenbenkuang" id="remark">${reader.remark}</textarea></td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
        <td><input  type="button" class="btn_grey" value="保存" onclick="modify()">
&nbsp;
<input name="Submit2" type="button" class="btn_grey" value="返回" onClick="history.back()"></td>
      </tr>
    </table>
	</form>
	</td>
  </tr>
</table></td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
</body>
</html>
