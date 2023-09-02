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
 * Time: 15:22
 */
//只有http请求的url中带有/hello才能调用，弱水三千只取一瓢之意
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这行代码一定要注释掉，因为这是调用父类的doGet
        // super.doGet(req, resp);
        //在服务器端的控制台上面打印hello world
        System.out.println("hello world");
        //在页面上也能打印hello world，把hello world字符串放到 http 响应的 body 中. 浏览器就会把 body 的内容
        //显示到页面上了
        resp.getWriter().write("hello world"+ System.currentTimeMillis());
    }
}

