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
 * Date: 2023-08-15
 * Time: 22:03
 */
@WebServlet("/index")
public class index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 返回一个主页. (主页就是一个简单的 html 片段)
        // 此处需要得到用户名是啥, 从 session 中就能拿到.
        // 此处 getSession 的参数必须是 false. 前面在登录过程中, 已经创建过会话了. 此处是要直接获取到之前的会话.
        HttpSession session =  req.getSession(false);
        String username = (String) session.getAttribute("username");
        // 还从会话中取出 count.由于返回的是一个Object类型的所以需要用包装类来接收
        Integer count = (Integer) session.getAttribute("count");
        count+=1;
        // 把自增之后的值写回到会话中.
        session.setAttribute("count",count);
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("<h3>欢迎你 "+username+"你访问了"+count+"次</h3>");
    }
}
