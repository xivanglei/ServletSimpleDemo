package demo.servlet.login;

import demo.Constans.HeadConst;
import demo.Constans.KeyConst;
import demo.Constans.UrlConst;
import demo.utils.HeadUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Author:xianglei
 * Date: 2019-12-25 11:49
 * Description:验证码图片
 */
@WebServlet(urlPatterns = UrlConst.URL_CHECK_CODE)
public class CheckCodeServlet extends HttpServlet {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 20;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //必须要进行响应前获取，否则给不到客户端
        HttpSession session = req.getSession();
        char[] rands = generateCheckCode();
        session.setAttribute(KeyConst.CHECK_CODE, new String(rands));
        resp.setContentType(HeadConst.CONTENT_TYPE_UTF8);
        ServletOutputStream sos = resp.getOutputStream();
        HeadUtil.setNoCacheHeader(resp);
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        drawBackground(g);
        drawRands(g, rands);
        //结束绘制
        g.dispose();
        //输出客户端
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", bos);
        byte[] buf = bos.toByteArray();
        resp.setContentLength(buf.length);
        //下面两种写法都行
        bos.writeTo(sos);
//        sos.write(buf);

        bos.close();
        sos.close();

    }

    //产生验证码
    private char[] generateCheckCode() {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        char[] result = new char[4];
        for(int i = 0; i < 4; i++) {
            result[i] = chars.charAt(new Random().nextInt(36));
        }
        return result;
    }

    //画验证码
    private void drawRands(Graphics g, char[] rands) {
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
        g.drawString(String.valueOf(rands[0]), 1, 17);
        g.drawString(String.valueOf(rands[1]), 16, 15);
        g.drawString(String.valueOf(rands[2]), 31, 18);
        g.drawString(String.valueOf(rands[3]), 46, 16);
        System.out.println(rands);
    }

    //画背景
    private void drawBackground(Graphics g) {
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        Random ran = new Random();
        for(int i = 0; i < 120; i++) {
            g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
            g.drawOval(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), 1, 0);
        }
    }

    public static String getSavedCheckCode(HttpServletRequest req) {
        return (String) req.getSession().getAttribute(KeyConst.CHECK_CODE);
    }
}
