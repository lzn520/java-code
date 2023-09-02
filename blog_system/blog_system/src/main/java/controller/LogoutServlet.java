package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-18
 * Time: 22:59
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null){
            //没有登录谈不上退出
            resp.getWriter().write("用户当前没有登录无法退出！");
            return;
        }
        //只需要把session清空就可以退出了
        session.removeAttribute("user");
        //跳转到登录页面
        resp.sendRedirect("blog_login.html");
    }
}
