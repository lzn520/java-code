package com.hj2022java.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-19
 * Time: 15:55
 */
public class firstAutotest {

    public void dilireba_test() throws InterruptedException {
        //创建一个驱动对象来打开浏览器
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        Thread.sleep(3000);
        //输入百度地址
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //找到百度输入框输入关键字迪丽热巴
        driver.findElement(By.cssSelector("#kw")).sendKeys("迪丽热巴");
        Thread.sleep(3000);
        //找到百度一下按钮并点击
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(3000);
        //关闭驱动，释放资源
        driver.quit();
    }


}
