package demo.Constans;

/**
 * Author:xianglei
 * Date: 2019-12-24 18:26
 * Description:各个页面的url地址
 */
public interface UrlConst {

    String BASE = "/Chapter03_war_exploded";            //应用包名

    String H5_WELCOME = "/welcome.html";                   //登录成功页
    String H5_LOGIN = "/login.html";                       //登录页



    String URL_DISPATCHER_TARGET = "/DispatcherTargetServlet";      //站内转发，包含目标页
    String URL_PURCHASE_BOOK = "/cart/PurchaseBookServlet";         //购买
    String URL_LIST_BOOK = "/cart/ListBookServlet";                 //书本列表页
    String URL_CHINESE_OUTPUT = "/ChineseOutputServlet";    //输出中文demo
    String URL_COOKIE = "/CookieServlet";                           //Coolie案例
    String URL_GET_CONTEXT_PARAMETER = "/GetContextParameterServlet";      //读取ServletContext参数(不是初始化参数),需要先进/SetContextParameterServlet
    String URL_SET_CONTEXT_PARAMETER = "/SetContextParameterServlet";      //设置ServletContext参数(不是初始化参数)
}
