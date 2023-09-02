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
 * Date: 2023-08-11
 * Time: 21:14
 */
@WebServlet("/method")
public class MethodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //要浏览器按照utf8的格式来读就不会乱码了
        resp.setContentType("text/html; charset=utf8");
        //super.doPost(req, resp);
        resp.getWriter().write("post 响应");
    }
}
