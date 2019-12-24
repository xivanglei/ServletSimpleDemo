package demo.servlet.sessionshoppingcart;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.PathConst;
import demo.bean.BookBean;
import demo.component.UrlParamBuild;
import demo.db.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xianglei
 * Date: 2019-12-24 09:11
 * Description:购物车书列表
 */
@WebServlet(urlPatterns = "/cart/ListBookServlet")
public class ListBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        PrintWriter out = resp.getWriter();
        out.println("本站提供的图书有:<br>");
        for(BookBean bean : BookDB.getAll()) {
            String url = UrlParamBuild.instance(PathConst.URL_BASE + PathConst.URL_PURCHASE_BOOK)
                    .addParam(KeyConst.ID, bean.getId())
                    .toUrl();
            out.println(bean.getName() + "<a href='" + url + "'>点击购买</a><br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
