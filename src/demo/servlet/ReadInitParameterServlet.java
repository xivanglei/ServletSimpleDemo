package demo.servlet;

import demo.Constans.UrlConst;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Author:xianglei
 * Date: 2019-12-21 18:45
 * Description:读取ServletContext初始化参数
 */
@WebServlet(urlPatterns = UrlConst.URL_READ_INIT_PARAMETER)
public class ReadInitParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletContext context = getServletContext();
        Enumeration<String> enumeration = context.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = enumeration.nextElement();
            out.print(parameterName + ":  ");
            out.print(context.getInitParameter(parameterName));
            out.println();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
