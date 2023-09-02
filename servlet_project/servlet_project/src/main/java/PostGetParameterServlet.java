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
 * Date: 2023-08-12
 * Time: 20:58
 */
@WebServlet("/postGetParameter")
public class PostGetParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userId =  req.getParameter("userId");
       String classId =  req.getParameter("classId");
       resp.getWriter().write("userId = "+userId+",classId = "+classId);
    }
}
