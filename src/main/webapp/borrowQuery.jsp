<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%@ page import="java.util.*"%>
<html>
<%
Collection coll=(Collection)request.getAttribute("borrowQuery");
%>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
<script src="JS/function.js"></script>

</head>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp" %>
<%@include file="navigation.jsp" %>
<script src="JS/borrowQuery.js"></script>
<table width="778" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF">
      <table width="99%" height="510" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
             class="tableBorder_gray">
        <tr>
          <td height="510" valign="top" style="padding:5px;">
            <table width="98%" height="487" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="22" valign="top" class="word_orange">当前位置：系统查询 &gt; 图书借阅查询 &gt;&gt;&gt;</td>
              </tr>
              <tr>
                <td align="center" valign="top">
                  <form name="myform" method="post" id="borrowQuery">
                    <table width="98%" height="67" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3F4F7"
                           class="tableBorder_gray">
                      <tr>
                        <td rowspan="2" align="center" bgcolor="#F9D16B">&nbsp;<img src="Images/search.gif" width="45"
                                                                                    height="28"></td>
                        <td height="29" bgcolor="#F9D16B">
                          <input name="flag" type="checkbox" class="noborder" value="a" checked>
                          请选择查询依据：
                          <select name="f" class="wenbenkuang" id="f">
                            <option value="barcode">图书条形码</option>
                            <option value="bookname">图书名称</option>
                            <option value="readerbarcode">读者条形码</option>
                            <option value="readername">读者名称</option>
                          </select>
                          <input name="key" type="text" id="key" size="50">
                          <input name="Submit" type="button" class="btn_grey" value="查询" onClick="checkBorrowQuery()">
                        </td>
                      </tr>
                      <tr>
                        <td height="26" bgcolor="#F9D16B">
                          <input name="flag" type="checkbox" class="noborder" value="b">
                          借阅时间： 从
                          <input name="sdate" type="date" id="sdate">
                          到
                          <input name="edate" type="date" id="edate">
                        </td>
                      </tr>
                    </table>
                  </form>
                  <%----%>
                  <div id="Query"></div>

                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <%@ include file="copyright.jsp" %>
    </td>
  </tr>
</table>
</body>
</html>
