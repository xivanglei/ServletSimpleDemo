package demo.servlet;

import demo.Constans.HeadConst;
import demo.Constans.PathConst;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

/**
 * Author:xianglei
 * Date: 2019-12-22 08:58
 * Description:读取资源文件,设置utf-8
 */
@WebServlet(urlPatterns = "/ReadResource")
public class ReadResource extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        ServletContext context = getServletContext();

        Properties pros = new Properties();
        //通过相对地址读取
//        pros.load(getRelativePath(context));
        //通过绝对地址读取
        pros.load(getAbsolutePath(context));
        Set<String> set = pros.stringPropertyNames();
        PrintWriter out = resp.getWriter();
        for(String name : set) {
            out.println(name + "=" + pros.getProperty(name) + "<br>");
        }
        out.println("相对地址是: " + PathConst.TEST_PROPERTIES + "<br>");
        out.println("绝对地址是: " + context.getRealPath(PathConst.TEST_PROPERTIES) + "<br>");
        out.println("URL地址是:" + context.getResource(PathConst.TEST_PROPERTIES).toString() + "<br>");
    }

    private InputStream getRelativePath(ServletContext context) {
        return context.getResourceAsStream(PathConst.TEST_PROPERTIES);
    }

    private FileInputStream getAbsolutePath(ServletContext context) throws IOException {
        String absolutePath = context.getRealPath(PathConst.TEST_PROPERTIES);
        return new FileInputStream(absolutePath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
