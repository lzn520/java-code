package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * model.User: LZN
 * Date: 2023-08-16
 * Time: 1:04
 */
//通过这个类，来处理/blog路径对应的请求
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    //为了使得区分blog请求里面是否带有后缀来分别执行代码我们先查看是否有blogId

    //这个方法来获取到数据库中的博客列表
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset = utf8");
        // 先尝试获取到 req 中的 blogId 参数. 如果该参数存在, 说明是要请求博客详情
        // 如果该参数不存在, 说明是要请求博客的列表.
        String param  = req.getParameter("blogId");
        BlogDao blogDao = new BlogDao();
        if(param == null){
            //当请求为空的时候
            //从数据库中查询到博客列表，转成JSON格式，然后直接返回即可
            List<Blog> blogs = blogDao.selectAll();
            //把blogs对象转成json格式
            String respjson = objectMapper.writeValueAsString(blogs);
            resp.getWriter().write(respjson);
        }else {
            //请求不为空，获取博客详情
            int blogId = Integer.parseInt(param);
            Blog blog = new Blog();
            blog = blogDao.selectOne(blogId);
            String respjson = objectMapper.writeValueAsString(blog);
            resp.getWriter().write(respjson);
        }



    }

    //用来执行用户发布文章到数据库
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("用户未登录！");
            return;
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("用户未登录！");
            return;
        }
        //一定要先指定好请求按照哪种编码来解析
        req.setCharacterEncoding("utf8");
        // 先从请求中, 取出参数(博客的标题和正文)
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(title == null || "".equals(title) || content == null || "".equals(content)){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("博客参数缺失！");
            return;
        }
        // 构造 Blog 对象, 把当前的信息填进去, 并插入数据库中
        // 此处要给 Blog 设置的属性, 主要是 title, content, userId (作者信息)
        // postTime 和 blogId 都不需要手动指定, 都是插入数据库的时候自动生成的.
        Blog blog = new Blog();
        BlogDao blogDao = new BlogDao();
        blog.setTitle(title);
        blog.setContent(content);
        //还需要知道作者id，我们可以通过session拿到
        blog.setUserId(user.getUserId());
        //再把这条添加到数据库
        blogDao.insert(blog);

        //跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }
}
