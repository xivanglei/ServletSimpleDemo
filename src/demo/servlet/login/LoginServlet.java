package demo.servlet.login;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.UrlConst;
import demo.bean.User;
import demo.utils.CommonUtil;
import demo.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xianglei
 * Date: 2019-12-25 10:29
 * Description:
 */
@WebServlet(urlPatterns = UrlConst.URL_LOGIN)
public class LoginServlet extends HttpServlet {

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
        PrintWriter out = resp.getWriter();

        if(StringUtil.equals(username, ADMIN_USERNAME) && StringUtil.equals(password, ADMIN_PASSWORD)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            req.getSession().setAttribute(KeyConst.USER, user);
            CommonUtil.redirect(resp, UrlConst.URL_INDEX);
        } else {
            out.println("用户名或密码错误，登录失败");
        }

    }
}
