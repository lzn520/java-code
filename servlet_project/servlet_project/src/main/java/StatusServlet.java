import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:查看一下响应的状态码
 * User: LZN
 * Date: 2023-08-13
 * Time: 11:48
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(404);
        resp.getWriter().write("hello");
    }
}
