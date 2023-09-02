package com.hj2022java.test2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import sun.reflect.misc.FieldUtil;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 12:16
 */
public class AutoTest {
    private ChromeDriver driver;
    public AutoTest(ChromeDriver driver) {
        this.driver = driver;
    }



    public void startDriver(){
        //创建一个驱动对象来打开浏览器
        driver.get("https://www.baidu.com");
//        driver.get("https://news.baidu.com/");
//        driver.get("https://tool.lu/");
        //隐式等待三秒
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }
    /////////////////////////////////////
    //中间写其他代码
    public  void  printtest(){
        //1.信息打印，获取到当前页面的title
        String title = driver.getTitle();
        System.out.println("title:"+title);
        //2.打印当前页面的url
        String cururl =  driver.getCurrentUrl();
        System.out.println("cururel:"+cururl);
        //先进入到百度首页之后，点击新闻超链接，然后打印title和url
        //会发现就算强制等待以后，打印的还是百度页面的，因为selenium并不知道彰显最新的页面是啥
        // 但是selenium对每一个标签页都给了一个唯一的标识，称为句柄
        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        String xwtitle =  driver.getTitle();
        System.out.println("expect：百度新闻——海量中文资讯平台 actual："+xwtitle);
        String xwurl =  driver.getCurrentUrl();
        System.out.println("expect:https://news.baidu.com/ actual:"+xwurl);
    }
    public void ChangeTest(){
        // 但是selenium对每一个标签页都给了一个唯一的标识，称为句柄
        //获取当前页面的句柄
        String curwindow = driver.getWindowHandle();
        System.out.println("当前页面的句柄是："+curwindow);
        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        //跳转以后在获取一下页面句柄
        String xwcurwindow =  driver.getWindowHandle();
        System.out.println("当前页面的句柄是："+curwindow);

        //获取所有页面的句柄,会发现getwindowHandle的返回值是Set<String>
        Set<String> allowiondow = driver.getWindowHandles();
        //通过for循环打印一下,第二个句柄就是新闻页面的句柄，可以从allowindow集合中取出我想要的句柄，然后跳转
        for (String window:allowiondow){
            if(window != curwindow) {
                //如果获取到的句柄不是当前页面的句柄，那么就要跳转到该句柄页面
                driver.switchTo().window(window);

            }
//            System.out.println("everyallowindow_handle"+window);
        }
        //跳转以后打印一下
        String xwtitle =  driver.getTitle();
        System.out.println("expect：百度新闻——海量中文资讯平台 actual："+xwtitle);
        String xwurl =  driver.getCurrentUrl();
        System.out.println("expect:https://news.baidu.com/ actual:"+xwurl);
    }

    public void  windowTest() throws InterruptedException {
        //窗口最大化
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        //窗口最小化
//        driver.manage().window().minimize();
//        Thread.sleep(2000);
//        //还可以设置窗口大小
//        driver.manage().window().setSize(new Dimension(1000,800));
//        Thread.sleep(2000);

        //selenium不能够直接编译js语言，但是仍然可以使用方法来执行
        driver.executeScript("window.scroll(0,document.scrollHeight)");
        Thread.sleep(2000);
        driver.executeScript("window.scroll(0,document.scrollTop)");
        Thread.sleep(2000);

    }
    public void  navigateTest() throws InterruptedException {
        //3.导航
        //先点击到网页中的文本类，然后在使用导航后退
        driver.findElement(By.cssSelector("#page > div:nth-child(1) > div.tabs-wrap > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);
        //使用导航后退
        driver.navigate().back();
        Thread.sleep(2000);
        //使用导航前进
        driver.navigate().forward();
        Thread.sleep(2000);


    }

    public void alertTest(){
        //4.对弹窗进行操作
        //1>普通弹出就通过定位来关闭driver.findElement(By.cssSelector("")).click关闭
        //2>不能够在前端代码定位到的元素，比如从最上面弹出来的警示弹窗,需要用到Selenium中提供的Alert接口来处理
        //先把alert弹窗勾引出来
        driver.findElement(By.cssSelector("xxx")).click();
        //切换到警告弹窗上
        Alert alert = driver.switchTo().alert();
        //点击弹窗上的确认按钮
        alert.accept();
        //也可以点击取消按钮，前提是有取消按钮
        //alert.dismiss();
        //如果弹窗上有输入，用sendKeys进行输入
        alert.sendKeys("xxxxx");
    }

    public void mounseAndKeyboardTest() throws InterruptedException {
        //5.模拟鼠标移动到想要的元素上进行点击和键盘的操作，selenium提供一个actions的方法
        //这里失败了，暂时不知原因（已解决，需要perform()）
        //1>鼠标操作
        WebElement webElement = driver.findElement(By.cssSelector("#hotsearch-content-wrapper > li:nth-child(1) > a"));
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        //里面需要一个webElement的元素，我们会发现findElement的返回值就是webElement
        //鼠标移动过去
        //不要忘记perform
        actions.clickAndHold(webElement).perform();
        Thread.sleep(3000);
        //2>键盘的操作
        //就是sendKeys
    }

    public void selectTest(){
        //6.操作选择框，
        WebElement ele = driver.findElement(By.cssSelector("xxxx"));
        //提供了一个Select接口
        Select select = new Select(ele);
        //1>通过索引来定位选项，计数从0开始
        select.selectByIndex(0);
        //2>通过value值来定位，value值就是html代码中的
        select.selectByValue("10.09");
        //3>通过可见到的文本来定位
        select.selectByVisibleText("xxxx");
    }


    public void fileUplodeTest(){
        //7.文件的上传，页面中点击文件上传会弹出来系统窗口，
        //1>通过sendKeys方法输入想要上传的文件路径以及文件名来选择文件，就能达到上传的目的
        //找到上传文件按钮
        WebElement ele = driver.findElement(By.cssSelector("上传"));
        ele.sendKeys("自己想要上传文件的路径");

    }

    public void ScreenShotTest() throws IOException {
        //8.屏幕截图
        //复现一下上次由于代码执行很快但是渲染没跟上而报错了，使用屏幕截图来找原因
        //百度搜索关键词并验证结果也
        driver.findElement(By.cssSelector("#kw")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#su")).click();
        //屏幕截图
        //把截图保存到file中
        File srcfile = driver.getScreenshotAs(OutputType.FILE);
        //把屏幕截图文件保存到指定路径下
        File filename = new File("./src/test/autopic/my.png");
        FileUtils.copyFile(srcfile,filename);
        driver.findElement(By.cssSelector("#\\34  > div > h3 > a > div > div > p > span > span"));

    }
    ////////////////////////////////////
    public void closeDriver(){
        //关闭驱动器
        driver.quit();
    }

}
