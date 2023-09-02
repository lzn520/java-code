package Blog_test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 23:11
 */
public class InitAndEnd {
    //创建一个驱动对象来打开浏览器
    static ChromeDriver driver;



    //初始化动作,放在BeforeAll后面
    @BeforeAll
    static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    //退出关闭放在AfterAll后面
    @AfterAll
    static void close(){
        driver.quit();
    }

}
