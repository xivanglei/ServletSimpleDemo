package demo.servlet;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.UrlConst;
import demo.component.UrlParamBuild;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xianglei
 * Date: 2019-12-22 19:21
 * Description:请求调度器 请求转发，请求包含，属性传递
 */
@WebServlet(urlPatterns = "/RequestDispatcherServlet")
public class RequestDispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        //转发的同时先设置属性
        req.setAttribute(KeyConst.COMPANY, "祥雷");
        String url = UrlParamBuild.instance(UrlConst.URL_DISPATCHER_TARGET)
                .addParam("p1", "abc")
                .toUrl();
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        //请求转发
//        dispatcher.forward(req, resp);
        //请求包含，可以理解为接着先交给下一个页面处理返回，完了回来这个页面继续
        include(dispatcher, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void include(RequestDispatcher dispatcher, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("before including" + "<br>");
        dispatcher.include(req, resp);
        out.println("after including" + "<br>");
    }
}
