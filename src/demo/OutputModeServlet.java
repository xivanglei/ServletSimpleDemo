package demo;

import demo.Constans.HeadConst;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xianglei
 * Date: 2019-12-22 11:04
 * Description:介绍两种输出方式
 */
@WebServlet(urlPatterns = "/OutputModeServlet")
public class OutputModeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        byteOutput(resp);
//        stringOutPut(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void byteOutput(HttpServletResponse resp) throws IOException {
        String text = "我是byte方式输出,不能两种方式同时用";
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(text.getBytes());
    }

    private void stringOutPut(HttpServletResponse resp) throws IOException {
        String text = "我是字符串方式输出,不能两种方式同时用";
        PrintWriter out = resp.getWriter();
        out.println(text);
    }
}
