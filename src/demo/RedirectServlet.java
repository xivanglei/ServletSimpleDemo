package demo;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.PathConst;
import demo.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:xianglei
 * Date: 2019-12-22 16:34
 * Description:请求重定向
 */
@WebServlet(urlPatterns = "/RedirectServlet")
public class RedirectServlet extends HttpServlet {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "123456";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        String username = req.getParameter(KeyConst.USERNAME);
        String password = req.getParameter(KeyConst.PASSWORD);

        //根据是否登录成功重定向到不同页面
        if(StringUtil.equals(username, ADMIN_USERNAME) && StringUtil.equals(password, ADMIN_PASSWORD)) {
            resp.sendRedirect(PathConst.URL_WELCOME);
        } else {
            resp.sendRedirect(PathConst.URL_LOGIN);
        }

    }
}
