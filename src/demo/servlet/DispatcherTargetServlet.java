package demo.servlet;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.UrlConst;
import demo.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xianglei
 * Date: 2019-12-22 19:24
 * Description:调度器转发的目标页
 */
@WebServlet(urlPatterns = UrlConst.URL_DISPATCHER_TARGET)
public class DispatcherTargetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //其实这里设置不起作用，因为示例对象在转发之前已经创建，编码模式也已经确定
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        PrintWriter out = resp.getWriter();
        String company = (String) req.getAttribute(KeyConst.COMPANY);
        if(StringUtil.isNotBlank(company)) {
            out.println("公司名称: " + company + "<br>");
        }
        out.println("中国" + "<br>");
        out.println("URI: " + req.getRequestURI() + "<br>");
        out.println("QueryString: " + req.getQueryString() + "<br>");
        out.println("parameter p1: " + req.getParameter(KeyConst.P1) + "<br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
