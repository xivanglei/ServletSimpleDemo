package demo.servlet.sessionshoppingcart;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.UrlConst;
import demo.bean.BookBean;
import demo.utils.ListUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Author:xianglei
 * Date: 2019-12-25 09:05
 * Description:购物车
 */
@WebServlet(urlPatterns = UrlConst.URL_CART)
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        PrintWriter out = resp.getWriter();
        Set<BookBean> cart = null;
        HttpSession session = req.getSession(false);
        if(session != null) {
            cart = (Set) session.getAttribute(KeyConst.CART);
        }
        if(ListUtil.isEmpty(cart)) {
            out.println("对不起，您还没有购买任何商品！");
            return;
        }
        out.println("您购买的图书有:<br>");
        for(BookBean bean : cart) {
            out.println(bean.getName() + "<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
