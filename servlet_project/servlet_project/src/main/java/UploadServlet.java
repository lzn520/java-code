import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-15
 * Time: 22:22
 */
//要加上这个注解开启对上传文件的支持
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Part part = req.getPart("MyImage");
       System.out.println(part.getSubmittedFileName());
       System.out.println(part.getContentType());
       System.out.println(part.getSize());
       //把上传获得到的文件写入这个目录
       part.write("d:/Ajava102/aaa.jpg");
       resp.setContentType("text/html;charset=utf8");
       resp.getWriter().write("上传成功");


    }
}
