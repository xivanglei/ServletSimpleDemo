package demo.servlet.login;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.UrlConst;
import demo.bean.User;
import demo.utils.CommonUtil;
import demo.utils.UrlUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xianglei
 * Date: 2019-12-25 10:36
 * Description:模拟首页展示session处理
 */
@WebServlet(urlPatterns = UrlConst.URL_INDEX)
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(KeyConst.USER);
        PrintWriter out = resp.getWriter();
        if(user == null) {
            out.println("您还没有登录，请" + UrlUtil.getALink(UrlConst.H5_LOGIN_SESSION, "登录"));
            return;
        }
        out.println("您已登录，欢迎你，" + user.getUsername() + "!");
        out.println(UrlUtil.getALink(UrlConst.URL_LOGOUT, "退出"));
        CommonUtil.saveSessionId(resp, session.getId());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
