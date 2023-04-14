import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-14
 * Time: 19:42
 */
public class JDBCSelect {
    public static void main(String[] args) throws SQLException {
        //1.创建并初始化数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java107?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("111111");
        //2.建立连接
        Connection connection = dataSource.getConnection();;
        //3.构造sql
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4.执行sql
        ResultSet resultSet = statement.executeQuery();//返回的表用resultset存储
        //5.遍历结果集合
        while(resultSet.next()){
            //把resultset想象成一个表格,同时表格这里有一个光标,初始情况下光标指向表最上面
            //每次调用next,光标就往下走一行~
            //当光标指向某一行的时候,就可以通过getxxx方法获取到当前这一行的数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id = "+id+ " name = "+name);
        }
        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
