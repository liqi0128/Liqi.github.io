<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2019/5/8
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="JS/jquery-3.2.1.js"></script>
<script >
    function nn() {
        var url="Library/tt";
        var data=$("form").serialize();
        var callback=function(data){
            alert(data);

        }
        var type="text";
        $.get(url,data,callback,type );

    }

</script>
 <body>
<form about="/book/tt?id=123" method="get">
    <input type="date" name="id" value="${date}" id="admin">
    <input type="submit" value="提交" onclick="nn()">

</form>
</body>
</html>
