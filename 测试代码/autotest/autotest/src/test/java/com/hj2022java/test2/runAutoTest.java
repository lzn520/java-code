package com.hj2022java.test2;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 12:16
 */
public class runAutoTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        //创建一个驱动对象来打开浏览器
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        AutoTest autoTest = new AutoTest(driver);
        autoTest.startDriver();
        /////////////////////////
        //中间写执行代码
//        autoTest.printtest();
//        autoTest.windowTest();
//        autoTest.navigateTest();
//        autoTest.mounseAndKeyboardTest();
//        autoTest.ScreenShotTest();
        /////////////////////////

        autoTest.closeDriver();
    }
}
