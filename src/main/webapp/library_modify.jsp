<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>

<script language="javascript">
    $(function(){
        var out=${out};
        if (out !== null || out !== undefined || out !== '') {
            alert(out);
        }

    });

function checkForm(form){
	for(i=0;i<form.length;i++){
		if(form.elements[i].value==""){
			alert("请将信息添写完整!");
			form.elements[i].focus();
			return false;
		}
	}
	/*var url="Library/Modify";
	var data=$("form").serialize();
    var callback=function(data){
        window.location.href='Manager/main'
        alert(data);
        if(data == 0){
            alert("操作失败");
        }else{
            alert("操作成功");
            window.location.href='Manager/main'
        }
    }
    var type="text";
    $.get(url,data,callback,type );*/


}
</script>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：系统设置 &gt; 图书馆信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="84%">&nbsp;      </td>
</tr>
</table>  <form name="form1" id="libraryModify"   method="post" >
  <table width="58%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#D2E3E6" bordercolorlight="#FFFFFF">
  <tr align="center">
    <input name="id" type="hidden" id="id" value="${library.id}" >
    <td width="20%" align="left" style="padding:5px;">图书馆名称：</td>
    <td width="80%" align="left">
      <input name="libraryname" type="text" id="libraryname" value="${library.libraryname}" size="30">
    
    </td>
    <tr>
    <td align="left" style="padding:5px;">馆长：</td>
    <td align="left"><input name="curator" type="text" id="curator" size="30" value="${library.curator}" ></td>
    </tr>
    <tr>
      <td align="left" style="padding:5px;">联系电话：</td>
      <td align="left"><input name="tel" type="text" id="tel" size="30" value="${library.tel}"></td>
    </tr>
    <tr>
      <td align="left" style="padding:5px;">联系地址：</td>
      <td align="left"><input name="address" type="text" id="address" size="30" value="${library.address}"></td>
    </tr>
    <tr>
      <td align="left" style="padding:5px;">联系邮箱：</td>
      <td align="left"><input name="email" type="text" id="email" size="30" value="${library.email}"></td>
    </tr>
    <tr>
      <td align="left" style="padding:5px;">图书馆网址：</td>
      <td align="left"><input name="url" type="text" id="url" size="30" value="${library.url}"></td>
    </tr>
    <tr>
      <td align="left" style="padding:5px;">建馆时间：</td>
      <td align="left"><input name="createDate" type="date" id="createDate" size="30" value="${library.createDate}"/>
      (日期格式：2007/11/22)</td>
    </tr>
    <tr>
      <td height="84" align="left" style="padding:5px;">图书馆简介：</td>
      <td align="left"><textarea name="introduce" cols="50" rows="5" class="wenbenkuang" id="introduce">${library.introduce}</textarea></td>
    </tr>
    <tr>
      <td height="65" align="left" style="padding:5px;">&nbsp;</td>
      <td><input name="Submit" type="button" class="btn_grey" value="保存" onClick="checkForm(form1)">
        &nbsp;
        <input name="Submit2" type="reset" class="btn_grey" value="取消"></td>
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
<script language="javascript">


    function checkForm(form){
        for(i=0;i<form.length;i++){
            if(form.elements[i].value==""){
                alert("请将信息添写完整!");

                return false;
            }
        }
        var url="Library/Modify";
        var data=$("#libraryModify").serialize();
        var callback=function(data){

            if(data.flag == 0){
                alert("操作失败");
            }else{
                alert("操作成功");
                window.location.href='Manager/main'
            }
        }
        var type="json";
        $.get(url,data,callback,type );


    }
</script>
</html>