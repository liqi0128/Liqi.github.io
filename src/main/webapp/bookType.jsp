<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<style>
  .div{
    width: 292px;
    height: 175px;
    background-color: #fff;
    position: fixed;
    top: 30%;
    left: 0;
    right: 0;
    margin:0 auto;
    display: none;

  }
</style>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<script src="JS/bookType.js"></script>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：图书管理 &gt; 图书类型设置 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
          <%----%>
          <c:if test="${empty bookTypeList}">
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无图书类型信息！</td>
            </tr>
          </table>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
      <a href="#" onClick="bookTypeAdd()">添加图书类型信息</a> </td>
  </tr>
</table>
          </c:if>
            <%----%>
            <c:if test="${not empty bookTypeList}">
 <table width="91%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="82%">&nbsp;      </td>
<td width="18%" align="right">
      <a href="#" onClick="bookTypeAdd()">添加图书类型信息</a> </td>
  </tr>
</table>  
  <table width="91%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="35%" bgcolor="#F9D16B">图书类型名称</td>
    <td width="35%" bgcolor="#F9D16B">可借天数</td>
    <td width="16%" bgcolor="#F9D16B">修改</td>
    <td width="14%" bgcolor="#F9D16B">删除</td>
  </tr>

    <%----%>
    <c:forEach var="bookType" items="${bookTypeList}">
  <tr>
    <td style="padding:5px;">${bookType.typename}</td>
    <td style="padding:5px;">${bookType.days}</td>
    <td align="center"><a href="javascript:void(0);" onClick="bookTypeModify(${bookType.id},'${bookType.typename}',${bookType.days})">修改</a></td>
    <td align="center"><a href="javascript:void(0);" onclick="del(${bookType.id})">删除</a></td>
  </tr>
    </c:forEach>
    </c:if>

    <%----%>
</table></td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
<!-- 遮罩层 -->
<div id="cover" style="background: #000; position: absolute; left: 0px; top: 0px; width: 100%;height: 100%; filter: alpha(opacity=30); opacity: 0.3; display: none; z-index: 0 "></div>
<div class="div">

</div>
</body>
</html>
