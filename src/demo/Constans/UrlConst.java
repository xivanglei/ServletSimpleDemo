package demo.Constans;

/**
 * Author:xianglei
 * Date: 2019-12-24 18:26
 * Description:各个页面的url地址
 */
public interface UrlConst {

    String BASE = "/Chapter03_war_exploded";            //应用包名

    String H5_WELCOME = "/welcome.html";                   //登录成功页
    String H5_LOGIN_REDIRECT = "/login_redirect.html";     //登录页,跳转重定向页，演示redirect demo
    String H5_LOGIN_SESSION = "/login_session.html";       //登录页，演示session



    String URL_DISPATCHER_TARGET = "/DispatcherTargetServlet";      //站内转发，包含目标页

    String URL_PURCHASE_BOOK = "/cart/PurchaseBookServlet";         //购买
    String URL_LIST_BOOK = "/cart/ListBookServlet";                 //书本列表页
    String URL_CART = "/cart/CartServlet";                               //演示读取session的购物车

    String URL_CHINESE_OUTPUT = "/ChineseOutputServlet";            //输出中文乱码解决demo
    String URL_REQUEST_PARAM = "/RequestParamServlet";              //获取请求参数，解决获取的中文乱码
    String URL_COOKIE = "/CookieServlet";                           //Coolie案例
    String URL_GET_CONTEXT_PARAMETER = "/GetContextParameterServlet";      //读取ServletContext参数(不是初始化参数),需要先进/SetContextParameterServlet设置
    String URL_SET_CONTEXT_PARAMETER = "/SetContextParameterServlet";      //设置ServletContext参数(不是初始化参数)
    String URL_NO_CACHE = "/NoCacheServlet";                            //禁止缓存
    String URL_NOTE_SET = "/NoteSetServlet";                            //注解方式设置Servlet信息演示
    String URL_OUTPUT_MODE = "/OutputModeServlet";                      //介绍两种输出模式
    String URL_READ_INIT_PARAMETER = "/ReadInitParameterServlet";       //演示读取ServletContext初始化参数
    String URL_READ_RESOURCE = "/ReadResourceServlet";                  //读取properties资源文件
    String URL_REDIRECT = "/RedirectServlet";                           //请求重定向，会产生location响应头和302响应码
    String URL_REFRESH = "/RefreshServlet";                             //自动刷新，包括定时刷新到其他页面，当前页面多次间隔刷新
    String URL_REQUEST_DISPATCHER = "/RequestDispatcherServlet";        //请求调度器，跟重定向不一样，这里只是请求其他页面帮忙处理事件，url不会变。包括请求转发（交给其他页面处理），请求包含（把其他页面当工具页，处理完再回来继续）

    String URL_LOGIN = "/login/LoginServlet";                           //登录页展示session处理
    String URL_INDEX = "/login/IndexServlet";                           //模拟首页展示session处理
    String URL_LOGOUT = "/login/LogoutServlet";                         //退出登录展示session处理
    String URL_CHECK_CODE = "/login/CheckCodeServlet";                  //验证码图片获取


}
