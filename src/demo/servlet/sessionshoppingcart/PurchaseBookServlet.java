package demo.servlet.sessionshoppingcart;

import demo.Constans.UrlConst;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Author:xianglei
 * Date: 2019-12-24 18:21
 * Description:购买书--通过session储存
 */
@WebServlet(urlPatterns = UrlConst.URL_PURCHASE_BOOK)
public class PurchaseBookServlet extends HttpServlet {
}
