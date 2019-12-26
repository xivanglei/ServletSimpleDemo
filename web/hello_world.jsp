<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.IOException" %><%--
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
    <%--脚本片段是输出代码--%>
    <%
        out.print(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(System.currentTimeMillis()));
    %>
    <%--表达式是直接在代码out中输出--%>
    <%--<%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(System.currentTimeMillis()))--%>

    <%--多个脚本片段与表达式可以拼在一起--%>
    <%for(int i = 1; i < 3; i++) {%>
        <h<%=i %>>    输出祥雷，标签是h<%=i%>   </h<%=i%>>
    <%}%>

    <%--上面的表达式或脚本片段都会出现在_jspService方法中--%>

    <%--这里展示JSP声明 出现在方法外，就是自己实现方法--%>
    <%!
        static {
            System.out.println("static code block");
        }
    %>
    <%--也可以几段一起--%>
    <%!
        private int i = 9;
        public static String str = "jsp展示";

        private String outTest() {
            return"调这方法就能输出" + i;
        }

        public void jspInit() {
            System.out.println("我还能覆写jspInit方法，HttpJspBase是继承HttpServlet的，HttpServlet里的init方法调用了jspInit()与_jspInit()");
        }
    %>

    <%=outTest() %>

    <%--文件源码生成在tomcat的根目录/work/Catalina/localhost/应用名/org/apache/jsp 下，
        但IntelliJ IDEA 配置了tomcat 所以这个文件生成在这个目录下
        /Users/xianglei/Library/Caches/IntelliJIdea2018.3/tomcat/Tomcat_9_0_14_Chapter03/work/Catalina/localhost/Chapter03_war_exploded/org/apache/jsp/hello_005fworld_jsp.java--%>
</body>
</html>
