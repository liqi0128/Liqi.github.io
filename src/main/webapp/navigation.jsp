<%@ page contentType="text/html; charset=utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="JS/onclock.JS" charset="gbk"></script>
<script src="JS/menu.JS" charset="gbk"></script>
<script src="JS/jquery-3.2.1.js" ></script>
<div class=menuskin id=popmenu
      onmouseover="clearhidemenu();highlightmenu(event,'on')"
      onmouseout="highlightmenu(event,'off');dynamichide(event)" style="Z-index:100;position:absolute;"></div>
<table width="778"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr bgcolor="#DFA40C">
        <td width="3%" height="27">&nbsp;</td>
        <td width="29%"><div id="bgclock" class="word_white"></div></td>
		<script language="javascript">


			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="Manager/out";
				}
			}
		</script>

        <td width="66%" align="right" bgcolor="#B0690B" class="word_white"><a href="Manager/main" class="word_white">首页</a> |
        <c:if test="${manager.purview.sysset eq 1}"><a  onmouseover=showmenu(event,sysmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand" >系统设置</a> |</c:if>
            <c:if test="${manager.purview.readerset eq 1}"><a  onmouseover=showmenu(event,readermenu) onmouseout=delayhidemenu() style="CURSOR:hand"  class="word_white">读者管理</a> |</c:if>
            <c:if test="${manager.purview.bookset eq 1}"><a  onmouseover=showmenu(event,bookmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand" >图书管理</a> |</c:if>
            <c:if test="${manager.purview.borrowback eq 1}"><a  onmouseover=showmenu(event,borrowmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand">图书借还</a> |</c:if>
            <c:if test="${manager.purview.sysquery eq 1}"><a  onmouseover=showmenu(event,querymenu) onmouseout=delayhidemenu()  class="word_white" style="CURSOR:hand" >系统查询</a> |</c:if>
            <a  href="pwd_Modify.jsp" class="word_white">更改口令</a> | <a href="#" onClick="quit()" class="word_white">退出系统</a></td>
        <td width="2%" bgcolor="#B0690B">&nbsp;</td>
  </tr>
      <tr bgcolor="#DFA40C">
        <td height="9" colspan="4" background="Images/navigation_bg_bottom.gif"></td>
      </tr>
</table>
