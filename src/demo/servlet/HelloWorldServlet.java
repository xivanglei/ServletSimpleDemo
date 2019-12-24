package demo.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xianglei
 * Date: 2019-12-21 17:16
 * Description:第一行Servlet代码
 */
public class HelloWorldServlet extends GenericServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init method is called");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        System.out.println("Hello World");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy method is called");
    }
}
