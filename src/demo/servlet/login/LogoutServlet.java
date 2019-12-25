package demo.servlet.login;

import demo.Constans.KeyConst;
import demo.Constans.UrlConst;
import demo.utils.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:xianglei
 * Date: 2019-12-25 11:29
 * Description:退出登录
 */
@WebServlet(urlPatterns = UrlConst.URL_LOGOUT)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(KeyConst.USER);
        CommonUtil.redirect(resp, UrlConst.URL_INDEX);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
