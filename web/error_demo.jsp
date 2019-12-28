<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-12-27
  Time: 08:06
  To change this template use File | Settings | File Templates.
  展示出错跳转错误页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    errorPage="error_page.jsp" %>
    <%--错误页还可以通过web.xml中的<error-page>来配置--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int a = 1 / 0;
    %>
</body>
</html>
