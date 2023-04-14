import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-14
 * Time: 17:53
 */
public class JDBCInsert {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //JDBC需要通过以下步骤完成开发
        //1.创建并初始化一个数据源
        DataSource dataSource = new MysqlDataSource();//datasource是接口不能new,只能new一个实现这个接口的类
        //由于seturl方法是子类特有的,所以要向下转型,找到数据库在哪
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java107?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("111111");
        //2.和数据库服务器建立连接
        Connection connection = dataSource.getConnection();//和数据库建立连接,用alt+回车抛出异常
        //从控制台读取用户的输入内容
        System.out.println("请输入学生姓名: ");
        String name = scanner.nextLine();
        System.out.println("请输入学号: ");
        int id = scanner.nextInt();
        //3.构造sql语句
        /* String sql = "insert into student values("+id+",'"+name+"')";//这种写法很丑,而且容易导致sql注入*/
        //String sql = "insert into student values(1,'张三')";//硬编码
        String sql = "insert into student values(?,?)";//?是占位符
        PreparedStatement statement = connection.prepareStatement(sql);//对sql语句提前解析
        statement.setInt(1,id);//把占位符替换成指定值
        statement.setString(2,name);
        //打印要放在后面
        System.out.println(statement);
        //4.执行sql语句
        int ret = statement.executeUpdate(); //返回结果是一个int类型
        System.out.println("ret = "+ ret);
        //5.释放必要的资源
        statement.close();;
        connection.close();
    }
}
