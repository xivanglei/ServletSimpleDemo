package demo.servlet;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.UrlConst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:xianglei
 * Date: 2019-12-22 17:27
 * Description:获取请求参数，解决获取的中文乱码
 */
@WebServlet(urlPatterns = UrlConst.URL_REQUEST_PARAM)
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这句解决中文乱码
        req.setCharacterEncoding(HeadConst.UTF8);

        System.out.println("名字: " + req.getParameter(KeyConst.NAME));
        System.out.println("年龄: " + req.getParameter(KeyConst.AGE));
        System.out.print("爱好: ");
        int count = 0;
        for(String hobby : req.getParameterValues(KeyConst.HOBBY)) {
            System.out.print(++count + "-" + hobby + ",");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
