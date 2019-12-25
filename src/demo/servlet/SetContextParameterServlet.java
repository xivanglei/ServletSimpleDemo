package demo.servlet;

import demo.Constans.UrlConst;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:xianglei
 * Date: 2019-12-21 18:50
 * Description:设置ServletContext参数
 */
@WebServlet(urlPatterns = UrlConst.URL_SET_CONTEXT_PARAMETER)
public class SetContextParameterServlet extends HttpServlet {

    private static final String KEY_DATA = "data";
    private static final String VALUE_DATA = "this servlet save data";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        context.setAttribute(KEY_DATA, VALUE_DATA);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public static String getValueData(ServletContext context) {
        return (String) context.getAttribute(KEY_DATA);
    }
}
