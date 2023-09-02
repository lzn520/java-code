package model;

import model.DBUtil;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * model.User: LZN
 * Date: 2023-08-16
 * Time: 0:03
 */
//提供对用户表的基本操作，也就是增删改查
public class UserDao {
    //需要实现的操作
    //针对这个类来说，就简化的写，像注册/销号这样的功能就不考虑了

    //1.主要实现，根据用户名来查找用户信息
    //这个会在登录逻辑使用
    public  User selectByName(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            //由于username使用unique约束，查询到的结果要么是1，要么是0
            if (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }

        return  null;
    }
    //2.根据用户id来找用户信息
    //博客详情页，基于可以根据用户id来查询作者名字，把作者名字显示出来
    public User selectById(int userId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet = statement.executeQuery();
            //由于username使用unique约束，查询到的结果要么是1，要么是0
            if (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);

        }

        return  null;
    }
}
