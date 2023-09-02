import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:实现以下自动刷新
 * User: LZN
 * Date: 2023-08-13
 * Time: 11:55
 */
@WebServlet("/autoRefresh")
public class AutoRefreshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1表示一秒钟刷新一次
        resp.setHeader("Refresh","1");
        resp.getWriter().write("timeStamp:"+System.currentTimeMillis());
    }
}
