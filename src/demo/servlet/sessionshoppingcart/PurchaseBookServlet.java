package demo.servlet.sessionshoppingcart;

import demo.Constans.KeyConst;
import demo.Constans.UrlConst;
import demo.bean.BookBean;
import demo.db.BookDB;
import demo.utils.CommonUtil;
import demo.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:xianglei
 * Date: 2019-12-24 18:21
 * Description:购买书--通过session储存
 */
@WebServlet(urlPatterns = UrlConst.URL_PURCHASE_BOOK)
public class PurchaseBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(KeyConst.ID);
        if(StringUtil.isBlank(id)) {
            CommonUtil.redirect(resp, UrlConst.URL_LIST_BOOK);
            return;
        }
        BookBean bean = BookDB.getBookById(id);
        //创建session或获取之前的session  默认为req.getSession(true) 表示如果没有就创建新的session，false没有就返回null
        HttpSession session = req.getSession();
        Set<BookBean> cart = (Set) session.getAttribute(KeyConst.CART);
        if(cart == null) {
            cart = new HashSet<>();
            session.setAttribute(KeyConst.CART, cart);
        }
        cart.add(bean);
        //个人理解，通过标准的sessionId key 设置cookie,下次的访问就会带这个sessionId过来，系统就会找到缓存中的session出来，否则就会随机一个新的session
        Cookie cookie = new Cookie(KeyConst.JSESSIONID, session.getId());
        cookie.setMaxAge(30 * 60);
        cookie.setPath(UrlConst.BASE);
        resp.addCookie(cookie);
        CommonUtil.redirect(resp, UrlConst.URL_CART);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
