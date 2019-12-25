package demo.servlet;

import demo.Constans.UrlConst;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Author:xianglei
 * Date: 2019-12-21 18:12
 * Description:不用清单里取写<servlet>
 */
//urlPatterns 表示虚拟路径，loadOnstartUp表示初始化启动 越小越优先，initParams表示初始化设置的参数
@WebServlet(
        urlPatterns = UrlConst.URL_NOTE_SET,
        loadOnStartup = 2,
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8")}
        )
public class NoteSetServlet extends HttpServlet {

    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletConfig config = getServletConfig();
        Enumeration<String> enumeration = getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = enumeration.nextElement();
            out.print(parameterName);
            out.print(config.getInitParameter(parameterName));
            out.println();
        }
        out.println("count:" + ++count);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
