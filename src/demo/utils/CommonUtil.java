package demo.utils;

import demo.Constans.UrlConst;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:xianglei
 * Date: 2019-12-25 09:03
 * Description:
 */
public class CommonUtil {

    public static void redirect(HttpServletResponse resp, String url) throws IOException {
        resp.sendRedirect(UrlConst.BASE + url);
    }
}
