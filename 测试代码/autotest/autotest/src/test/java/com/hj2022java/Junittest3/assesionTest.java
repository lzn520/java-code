package com.hj2022java.Junittest3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 18:51
 */
public class assesionTest {
    ChromeDriver driver;

    public assesionTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        this.driver = driver;
    }
    //2.断言
    @Test
    void assertEqualsTest(){

        //先跳转到百度首页
        driver.get("https://www.baidu.com");
        //测试百度一下按钮上的属性值是否正确
        String test = driver.findElement(By.cssSelector("#su")).getAttribute("value");
        Assertions.assertEquals("百度一下",test);
        driver.quit();
    }
    @Test
    void assertTrueTest(){
        //先跳转到百度首页
        driver.get("https://www.baidu.com");
        //测试百度一下按钮上的属性值是否正确
        String test = driver.findElement(By.cssSelector("#su")).getAttribute("value");
        Assertions.assertTrue(test.equals("百度一下"));
        driver.quit();
    }

    @Test
    void assertNull(){
        String a = null;
        Assertions.assertNull(a);
    }

}
