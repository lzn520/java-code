import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-13
 * Time: 12:04
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在这里返回一个302重定向响应，让浏览器跳转到搜狗页面
        //其实很多浏览器的跳转都是通过重定向实现的
//        resp.setStatus(302);
//        resp.setHeader("Location","https://www.sogou.com");

        //但是Servlet提供了一个更简便的实现重定向的写法，
        resp.sendRedirect("https://www.sogou.com");
    }
}
