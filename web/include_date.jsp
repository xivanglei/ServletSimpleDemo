<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-12-27
  Time: 08:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        out.print("我是别的页面插入的时间");
        out.print(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(System.currentTimeMillis()));
    %>
</body>
</html>
