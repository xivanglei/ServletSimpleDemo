<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-12-27
  Time: 08:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>抱歉，服务器出现故障，正在解决，请稍后。。。。。。</h2>
    <%
        out.println("exception.toString:");
        out.println("<br>");
        out.println(exception.toString());
        out.println("<p>");
        out.println("exception.getMessage:<br>");
        out.println(exception.getMessage());
    %>
</body>
</html>
