package demo;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.utils.DateUtil;
import demo.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:xianglei
 * Date: 2019-12-23 08:53
 * Description:Coolie案例
 */
@WebServlet(urlPatterns = "/CookieServlet")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        String lastAccessTime = null;
        Cookie[] cookies = req.getCookies();
        if(cookies!= null) {
            for (Cookie cookie : cookies) {
                if(StringUtil.equals(cookie.getName(), KeyConst.LAST_ACCESS)) {
                    lastAccessTime = cookie.getValue();
                } else {
                    resp.getWriter().println(cookie.getName() + ":  " + cookie.getValue());
                }
            }
        }
        if(StringUtil.isNotBlank(lastAccessTime)) {
            resp.getWriter().println("您上次的访问时间是:" + lastAccessTime);
        } else {
            resp.getWriter().println("您是首次访问本站！！！");
        }

        resp.addCookie(new Cookie(KeyConst.LAST_ACCESS, DateUtil.getTime(DateUtil.DATE_TIME_2)));
        resp.addCookie(new Cookie("test", "other_cookie"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
