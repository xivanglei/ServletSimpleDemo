package demo.servlet;

import demo.Constans.HeadConst;
import demo.utils.HeadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:xianglei
 * Date: 2019-12-22 12:12
 * Description:自动刷新，包括定时刷新到其他页面，当前页面多次间隔刷新
 */
@WebServlet(urlPatterns = "/RefreshServlet")
public class RefreshServlet extends HttpServlet {

    private int count;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        refreshOtherUrl(resp);
        refreshThisPage(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //刷新到其他页面
    private void refreshOtherUrl(HttpServletResponse resp) {
        HeadUtil.setRefreshHeader(resp, 3, "http://www.baidu.com");
    }

    //间隔刷新当前页
    private void refreshThisPage(HttpServletResponse resp) throws IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        HeadUtil.setRefreshHeader(resp, 3, null);
        resp.getWriter().println("这是第" + ++count + "次打开这页,日期是:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }
}
