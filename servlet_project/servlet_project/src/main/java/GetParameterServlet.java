import com.sun.javafx.binding.StringFormatter;

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
 * Time: 19:43
 */
@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //函数里面的值表示请求值所对应的键是userId
       String userId =  req.getParameter("userId");
       String classId = req.getParameter("classId");
       resp.getWriter().write("userId="+userId+",classId="+classId);

    }
}
