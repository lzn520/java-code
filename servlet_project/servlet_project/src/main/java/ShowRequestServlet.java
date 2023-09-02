import com.sun.javafx.binding.StringFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-12
 * Time: 19:29
 */
@WebServlet("/ShowRequest")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求中的内容并且写在页面上显示出来
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h3>首行内容</h3>");
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getQueryString());
        stringBuilder.append("<h3>head 部分</h3>");
        Enumeration<String> headNames = req.getHeaderNames();
        while(headNames.hasMoreElements()){
            String headName = headNames.nextElement();
            String headValue = req.getHeader(headName);
            stringBuilder.append(headName + " : " + headValue + " <br> ");
        }
        resp.setContentType("text/html ;charset=utf8");
        resp.getWriter().write(stringBuilder.toString());
    }
}
