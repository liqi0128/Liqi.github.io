<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<style>
   /* *{
        margin: 0;
        padding: 0;//
    }*/
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
<script src="JS/manager.js" ></script>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
	<%@include file="navigation.jsp"%>
	<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：系统设置 &gt; 管理员设置 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
            <%--无管理员信息--%>
            <c:if test="${empty ManList}">
                <table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="36" align="center">暂无管理员信息！</td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>
                            <a href="javascript:void(0);" onClick="addManaget()">添加管理员信息</a>
                        </td>
                    </tr>
                </table>
            </c:if>
<c:if test="${not empty ManList}">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="84%">&nbsp;</td>
            <td width="16%">
                <a href="javascript:void(0);" onClick="addManaget()">添加管理员信息</a></td>
        </tr>
    </table>
    <table width="91%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B"
           bordercolorlight="#FFFFFF">
        <tr align="center" bgcolor="#e3F4F7">
            <td width="26%" bgcolor="#F9D16B">管理员名称</td>
            <td width="12%" bgcolor="#F9D16B">系统设置</td>
            <td width="12%" bgcolor="#F9D16B">读者管理</td>
            <td width="12%" bgcolor="#F9D16B">图书管理</td>
            <td width="11%" bgcolor="#F9D16B">图书借还</td>
            <td width="10%" bgcolor="#F9D16B">系统查询</td>
            <td width="9%" bgcolor="#F9D16B">权限设置</td>
            <td width="8%" bgcolor="#F9D16B">删除</td>
        </tr>

            <%--只有tsoft用户才可以修改删除 checked--%>
        <c:forEach var="list" items="${ManList}">
            <tr>
                <td style="padding:5px;">${list.name}</td>
                <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox"
                                          disabled="disabled" <c:if test="${list.purview.sysset eq 1}">checked</c:if> ></td>
                <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox"
                                          disabled="disabled" <c:if test="${list.purview.readerset eq 1}">checked</c:if> ></td>
                <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled <c:if test="${list.purview.bookset eq 1}">checked</c:if> >
                </td>
                <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled  <c:if test="${list.purview.borrowback eq 1}">checked</c:if> >
                </td>
                <td align="center"><input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled  <c:if test="${list.purview.sysquery eq 1}">checked</c:if> >
                </td>
                <td align="center">
                <c:choose>
                    <c:when test="${manager.name == 'tsoft'}">
                        <a href="javascript:void(0);" onClick="managerModify(${list.id})">权限设置</a>
                    </c:when>
                    <c:otherwise>
                        &nbsp;
                    </c:otherwise>
                </c:choose>
                </td>
                <td align="center">
                    <c:choose>
                        <c:when test="${manager.name == 'tsoft'}">
                            <a href="javascript:void(0);"  onclick="delManager('${list.name}',${list.id});">删除</a>
                        </c:when>
                        <c:otherwise>
                            &nbsp;
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
        </td>
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
