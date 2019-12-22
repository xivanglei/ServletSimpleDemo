package demo.utils;

import demo.Constans.HeadConst;

import javax.servlet.http.HttpServletResponse;

/**
 * Author:xianglei
 * Date: 2019-12-22 12:16
 * Description:
 */
public class HeadUtil {

    /**
     * 刷新页面
     * @param resp 响应体
     * @param second 几秒后刷新（秒）
     * @param url 刷新的地址，如果有就刷新到新地址，null就本地址刷新
     */
    public static void setRefreshHeader(HttpServletResponse resp, int second, String url) {
        resp.setHeader(HeadConst.REFRESH, second + (url == null ? "" : (";URL=" + url)));
    }

    /**
     * 为了支持多种浏览器，3中方式的响应头都设置
     * @param resp 响应体
     */
    public static void setNoCacheHeader(HttpServletResponse resp) {
        resp.setDateHeader(HeadConst.EXPIRES, 0);
        resp.setHeader(HeadConst.CACHE_CONTROL, HeadConst.NO_STORE);
        resp.setHeader(HeadConst.PRAGMA, HeadConst.NO_CACHE);
        //有些浏览器不管你这些设置，依然会缓存，加上这句就好了
        resp.setHeader(HeadConst.LAST_MODIFIED, DateUtil.getGMTTime());
    }
}
