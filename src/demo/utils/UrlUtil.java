package demo.utils;

import demo.Constans.UrlConst;

/**
 * Author:xianglei
 * Date: 2019-12-25 11:05
 * Description:创建url工具
 */
public class UrlUtil {

    public static String getALink(String targetUrl, String text) {
        return String.format("<a href='%s'>%s</a>", UrlConst.BASE + targetUrl, text);
    }
}
