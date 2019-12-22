package demo;

import com.sun.deploy.util.SessionState;
import com.sun.security.ntlm.Client;
import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.PathConst;
import demo.utils.PropertiesUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Author:xianglei
 * Date: 2019-12-22 11:14
 * Description:中文输出乱码问题
 */
@WebServlet(urlPatterns = "/ChineseOutputServlet")
public class ChineseOutputServlet extends HttpServlet {

    private static final String NORMAL_TEXT = "This is normal Chinese: 这是普通中文";
    private String propertiesText;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initPropertiesText();
        //这里展示乱码
//        messyCodeDemo(resp);
        //第一种方式解决乱码
//        setCharacterEncoding(resp);
        //第二种
//        setContentType(resp);
        //解决properties读取中文的乱码,地址必须要绝对地址
        loadChinesePropertiesText(getServletContext().getRealPath(PathConst.TEST_PROPERTIES));
        setContentType(resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void initPropertiesText() throws IOException {
        InputStream in = getRelativePath(getServletContext());
        Properties properties = new Properties();
        properties.load(in);
        propertiesText = "This is the Chinese of the attribute resource:" + properties.getProperty(KeyConst.CHINESE_TEST);
        System.out.println(propertiesText);
    }

    private void loadChinesePropertiesText(String path) {
        Properties properties = PropertiesUtil.loadFile(path);
        propertiesText = "This is the Chinese of the attribute resource:" + properties.getProperty(KeyConst.CHINESE_TEST);
    }

    private InputStream getRelativePath(ServletContext context) {
        return context.getResourceAsStream(PathConst.TEST_PROPERTIES);
    }

    private void messyCodeDemo(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println(NORMAL_TEXT + "<br>");
        out.println(propertiesText);
    }

    //第一种方式解决乱码，优先级比第二种高
    private void setCharacterEncoding(HttpServletResponse resp) throws IOException {
        //自己使用的编码方式
        resp.setCharacterEncoding(HeadConst.UTF8);
        //告诉接收客户端我的编码方式
        resp.setHeader(HeadConst.CONTENT_TYPE, HeadConst.CONTENT_TYPE_UTF8);
        messyCodeDemo(resp);
    }

    //第二种方式解决乱码
    private void setContentType(HttpServletResponse resp) throws IOException {
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        messyCodeDemo(resp);
    }
}
