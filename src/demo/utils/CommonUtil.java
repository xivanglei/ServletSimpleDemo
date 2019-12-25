package demo.utils;

import demo.Constans.KeyConst;
import demo.Constans.UrlConst;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:xianglei
 * Date: 2019-12-25 09:03
 * Description:
 */
public class CommonUtil {


    //请求重定向
    public static void redirect(HttpServletResponse resp, String url) throws IOException {
        resp.sendRedirect(UrlConst.BASE + url);
    }

    public static void saveSessionId(HttpServletResponse resp, String sessionId) {
        Cookie cookie = new Cookie(KeyConst.JSESSIONID, sessionId);
        cookie.setMaxAge(30 * 60);
        cookie.setPath(UrlConst.BASE);
        resp.addCookie(cookie);
    }
}
