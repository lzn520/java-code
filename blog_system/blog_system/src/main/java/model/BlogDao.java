package model;

import model.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * model.User: LZN
 * Date: 2023-08-16
 * Time: 0:02
 */
//这个类用来封装博客表的基本操作，也就是对博客表数据库的增删改查
public class BlogDao {
    //1.往博客表里，插入一个博客
    public void insert(Blog blog){
        //JDBC基本代码
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.和数据库建立连接
            connection = DBUtil.getConnection();
            //2.构造sql语句
            //now()是mysql的一个函数，取得是系统时间
            String sql = "insert into blog values(null,?,?,?,now())";
            statement = connection.prepareStatement(sql);
            statement.setString(1,blog.getTitle());
            statement.setString(2,blog.getContent());
            statement.setInt(3,blog.getUserId());
            //3.执行sql语句
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //4.关闭连接释放资源
            DBUtil.close(connection,statement,null);
        }

    }
    //2.能够获取到博客表中的所有博客信息（用于在博客列表页，此处每篇博客不一定会获取到完整的正文）
    public List<Blog> selectAll(){
        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        //用来放查询到的结果集
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            //取出查询到的结果集
            while(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                //由于用在博客列表页，所以博客内容过长的需要截断
                String content = resultSet.getString("content");
                if(content.length() > 50){
                    content = content.substring(0,50)+"....";
                }
                blog.setContent(content);
                blog.setUserId(resultSet.getShort("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return blogs;
    }
    //3.能够根据博客id获取到指定的博客内容（用于在博客详情页）
    public Blog selectOne(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            resultSet = statement.executeQuery();
            //此处我们是使用主键作为查询条件的，结果要么是1，要么是0
            if(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));

                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getShort("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return  null;
    }
    //4.从博客表中，根据博客id删除博客
     public void delete(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
         try {
             connection = DBUtil.getConnection();
             String sql = "delete from blog where blogId = ?";
             statement = connection.prepareStatement(sql);
             statement.setInt(1,blogId);
             statement.executeUpdate();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }finally {
             DBUtil.close(connection,statement,null);
         }
     }
    //注意上述操作是增删查，没有改，但是我们也可以加入

}
