import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-15
 * Time: 21:55
 */
@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理用户请求
       String username =  req.getParameter("username");
       String password = req.getParameter("password");
        // 判定用户名或者密码是否正确~~
        // 正常来说这个判定操作是要放到数据库中进行存取的.
        // 此处为了简单, 就直接在代码里写死了. 假设有效的用户名和密码是 "zhangsan", "123"
       //这样比较是为了防止空指针异常，万一输入的为空呢
       if ("zhangsan".equals(username) && "123".equals(password)){
           //创建会话并保存必要的身份信息
           HttpSession session = req.getSession(true);
           // 往会话中存储键值对. 必要的身份信息
           session.setAttribute("username",username);
           // 初始情况下, 把登录次数设为 0
           session.setAttribute("count",0);
           //登陆成功跳转到index页
           resp.sendRedirect("index");


       }else {
          //登陆失败！
           resp.getWriter().write("login failed");
       }
    }
}
