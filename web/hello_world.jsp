<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-12-26
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一行JSP</title>
</head>
<body>
    当前访问时间是：
    <%
        out.print(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(System.currentTimeMillis()));
    %>
</body>
</html>
