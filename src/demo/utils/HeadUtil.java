package demo.utils;

import demo.Constans.HeadConst;

import javax.servlet.http.HttpServletResponse;

/**
 * Author:xianglei
 * Date: 2019-12-22 12:16
 * Description:
 */
public class HeadUtil {

    public static void setRefreshHeader(HttpServletResponse resp, int second, String url) {
        resp.setHeader(HeadConst.REFRESH, second + (url == null ? "" : (";URL=" + url)));
    }
}
