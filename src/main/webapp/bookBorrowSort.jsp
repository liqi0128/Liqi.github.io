<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
    <base href="<%=basePath%>">
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：图书借阅排行榜 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
            <%----%>
            <c:if test="${empty borrowList}">
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无图书借阅信息！</td>
            </tr>
          </table>
            </c:if>
                <%----%>
                <c:if test="${not empty borrowList}">
 <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
  <td width="8%" bgcolor="#F9D16B">借阅次数</td>
    <td width="11%" bgcolor="#F9D16B">图书条形码</td>
    <td width="17%" bgcolor="#F9D16B">图书名称</td>
    <td width="15%" bgcolor="#F9D16B">图书类型</td>
    <td width="16%" bgcolor="#F9D16B">书架</td>
    <td width="14%" bgcolor="#F9D16B">出版社</td>
    <td width="11%" bgcolor="#F9D16B">作者</td>
    <td colspan="2" bgcolor="#F9D16B">定价(元)</td>
    </tr>

     <%----%>
     <c:forEach items="${borrowList}" var="borrow">
  <tr>
    <td align="center">&nbsp;${borrow.count}</td>
    <td style="padding:5px;">&nbsp;${borrow.bookinfo.barcode}</td>
    <td style="padding:5px;">${borrow.bookinfo.bookname}</td>
    <td style="padding:5px;">${borrow.booktype.typename}</td>
    <td align="center">&nbsp;${borrow.bookcase.name}</td>
    <td align="center">&nbsp;${borrow.publishing.pubname}</td>
    <td width="11%" align="center">${borrow.bookinfo.author}</td>
    <td width="8%" align="center">${borrow.bookinfo.price}</td>
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
</body>
</html>
