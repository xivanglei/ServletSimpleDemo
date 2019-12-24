package demo.servlet;

import demo.Constans.HeadConst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xianglei
 * Date: 2019-12-21 17:37
 * Description:请求方法的Servlet
 */
public class RequestMethodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        PrintWriter out = resp.getWriter();
        out.println("this is doGet method");
        doCommon(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        PrintWriter out = resp.getWriter();
        out.println("this is doPost method");
        doCommon(req, resp);
    }

    private void doCommon(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("我是默认页，因为在web.xml里标了<url-pattern>/</url-pattern>，\"/\"表示所有找不到的网页都可以跑到这里来");
    }
}
