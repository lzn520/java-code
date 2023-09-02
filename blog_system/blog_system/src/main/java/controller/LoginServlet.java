package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.UserDao;

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
 * Time: 19:30
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        //1.获取到请求中的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        if(username == null || "".equals(username) || password == null || "".equals(password)){
            //// 请求的内容缺失, 肯定是登录失败!!
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("用户名或者密码为空!");
            return;
        }
        //2. 和数据库中的内容进行比较
        UserDao userDao = new UserDao();
        User user =  userDao.selectByName(username);
        if(user == null || !user.getPassword().equals(password)){
            //// 用户没有查到或者密码不匹配, 也是登录失败!
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("用户名或者密码不对!");
            return;
        }
        // 3. 如果比较通过, 就创建会话.
        HttpSession session = req.getSession(true);
        // 把刚才的用户信息, 存储到会话中.
        session.setAttribute("user",user);
        // 4. 返回一个重定向报文, 跳转到博客列表页.
        resp.sendRedirect("blog_list.html");
    }

    //前端用来检查当前用户是否登录了
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");
        HttpSession session = req.getSession(false);
        if(session == null){
            //获取不到登录状态，返回username = 0的json格式数据
            User user = new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null){
            user = new User();
            //虽然有会话，但是user对象为空，也视作未登录
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        //到这里说明有登陆状态,注意不能把密码返回给前端了
        user.setPassword("");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }
}
