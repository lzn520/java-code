package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

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
 * Date: 2023-08-18
 * Time: 22:28
 */
@WebServlet("/authorInfo")
public class AuthorServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先通过blogId拿到博客，再通过博客找到作者
        resp.setContentType("application/json;charset=utf8");
        String param = req.getParameter("blogId");
        if(param == null || "".equals(param)){
            //参数缺失
            resp.getWriter().write("{\"ok\": false, \"reason\": \"参数缺失!\"}");
            return;
        }

        //根据当前的blogId在数据库中查找
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(param));
        if(blog == null){
            //没有该博客
            resp.getWriter().write("{\"ok\":false, \"reason\": \"博客不存在!\"}");
            return;
        }

        //到了这里说明博客存在，然后通过博客拿到作者id再去user里面查找作者信息
        UserDao userDao = new UserDao();
        User author = userDao.selectById(blog.getUserId());
        if (author == null){
            //没有该作者
            resp.getWriter().write("{\"ok\":false,\"reason\":\"作者不存在!\"}");
            return;
        }
        //拿到了作者信息以后，传给客户端,用json的格式
        //注意密码不要给前端了
        author.setPassword("");
        resp.getWriter().write(objectMapper.writeValueAsString(author));
    }
}
