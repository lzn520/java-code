package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * model.User: LZN
 * Date: 2023-08-15
 * Time: 23:36
 */
//使用这个类和数据库建立链接
public class DBUtil {
    private static final  String URL = "jdbc:mysql://127.0.0.1:3306/java102_blog?characterEncoding=utf8&useSSL=false";
    private static final String USERNAME="root";
    private static  final String PASSWORD="111111";
    private static volatile DataSource dataSource = null;
    private static DataSource getDataSource(){
      if(dataSource == null){
          synchronized (DBUtil.class){
              if(dataSource == null){
                  dataSource = new MysqlDataSource();
                  ((MysqlDataSource)dataSource).setUrl(URL);
                  ((MysqlDataSource)dataSource).setUser(USERNAME);
                  ((MysqlDataSource)dataSource).setPassword(PASSWORD);
              }
          }
      }
        return dataSource;
    }
    public  static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet ){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
