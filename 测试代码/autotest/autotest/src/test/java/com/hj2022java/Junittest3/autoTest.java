package com.hj2022java.Junittest3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 16:05
 */
//标注当前类使用方法来排序
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class autoTest {

    ChromeDriver driver;

    public autoTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        this.driver = driver;
    }
    //1.注解
    //@Test表示一个方法/用例，不需要调用就可以执行测试
    //@BeforeEach其他方法执行前我都要先执行一下
    //@BeforeAll所有方法执行前只需要执行一遍，但是使用它注解的方法必须定义为static的
    //@AfterEach @AfterAll同上
    //标注当前类使用方法来排序@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    //明确标注执行顺序@Order()可以手动设置用例的执行顺序，就让getUrl先执行，quit最后执行
    //
    /*测试百度首页展示元素是否正确*/



}
