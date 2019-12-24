package demo.servlet;

import demo.Constans.HeadConst;
import demo.utils.HeadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Author:xianglei
 * Date: 2019-12-22 12:37
 * Description:禁止缓存示例
 */
@WebServlet(urlPatterns = "/NoCacheServlet")
public class NoCacheServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        HeadUtil.setNoCacheHeader(resp);
        PrintWriter out = resp.getWriter();
        out.println("本次响应的随机数为: " + new Random().nextInt(200000));
        out.println("<form action='NotServlet' method='POST'>" +
                "第一个参数: <input type='text' name='p1'><br>" +
                "第二个参数: <textarea name='p2'></textarea><br>" +
                "<input type='submit' value='提交'>" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
