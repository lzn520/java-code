package com.hj2022java.Junittest3;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 18:53
 */

//1>标注当前类使用方法来进行排序
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMethodOrderTest {
    //3.用例执行顺序
    ChromeDriver driver;

    public TestMethodOrderTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        this.driver = driver;
    }

    //用@Order()明确标注具体的执行顺序
    @Test
    @Order(1)
    void printAAA(){
        System.out.println("aaaaa");
    }
    @Test
    @Order(2)
    void printBBB(){
        System.out.println("BBBB");
    }
}
