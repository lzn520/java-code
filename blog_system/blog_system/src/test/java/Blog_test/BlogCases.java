package Blog_test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 23:18
 */
//对测试方法进行排序
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//让博客系统的测试继承自InitAndEnd
public class BlogCases extends InitAndEnd{
    /**
     * 登录测试，输入正确的密码，登录成功
     */
    //进行参数化测试，把测试的值写入文件中,如果有@ParameterizedTest就不需要@Test了
    @Order(1)
    @ParameterizedTest
    @CsvFileSource(resources = "/login.csv")
    void LoginSuccessTest(String username,String password){
        //1.先进入到登录页面
        driver.get("http://127.0.0.1:8080/blog_system/blog_login.html");
        //2.找到输入框输入账号密码
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        //3.点击提交
        driver.findElement(By.cssSelector("#submit")).click();
        //让他显示等待一下
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //4.判断页面的url是否是列表页
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("http://127.0.0.1:8080/blog_system/blog_list.html",url);
        //当前用户的信息是zhangsan
        String cur_name =driver.findElement(By.cssSelector("body > div.container > div.left > div > h3")).getText();
        Assertions.assertEquals(username,cur_name);
        //是则测试通过，不是测测试失败
    }

    /**
     * 登录成功，测试博客列表的博客数量不为0
     */

    @Order(2)
    @Test
    void BlogListNumTest(){
        //1.先跳转到博客列表页
        driver.get("http://127.0.0.1:8080/blog_system/blog_list.html");
        //2.获取页面上所有页面标题对应的元素，注意使用的是findElements，后面有个s
        int title_num = driver.findElements(By.cssSelector("body > div.container > div.right > div:nth-child(1) > div.title")).size();
        //如果元素数量不为0，那么测试通过
        Assertions.assertNotEquals(0,title_num);
    }





    /**
     * 写博客和是发布博客测试
     * 自动化测试，点击发布按钮，博客跳转到详情页
     * 第一条博客是刚刚发布的博客，对比名称和时间
     */

    @Order(3)
    @Test
    void writeTest(){
        //1.点击写博客按钮，进入到写博客页面
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(5)")).click();
        //显示等待3s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //2.在输入框内输入，通过js脚本输入“自动化测试”标题
        driver.executeScript("document.getElementById(\"title\").value=\"自动化测试\"");
        //3.点击发布按钮
        driver.findElement(By.cssSelector("#submit")).click();
        //4.这个时候会跳转到列表页面
        //对比一下当前的url是否是列表页的url
        //显示等待3s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String curUrl =  driver.getCurrentUrl();
        Assertions.assertEquals("http://127.0.0.1:8080/blog_system/blog_list.html",curUrl);
        //看看当前页面的第一篇博客标题和时间是不是刚刚发布的博客
        String curTitle = driver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child(1) > div.title")).getText();
        Assertions.assertEquals("自动化测试",curTitle);
        String curTime = driver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child(1) > div.date")).getText();
        Assertions.assertTrue(curTime.contains("2023-08-21"));
    }



    @Order(4)
    @Test
    /**
     * 删除刚刚添加的自动化测试博客，点击删除按钮，跳转到博客列表页，博客列表页的第一篇博客已经不是
     * 原来被删除的博客名字，表示测试成功
     */
    void  deleteTest(){
       //1.先进入到博客列表页
        driver.get("http://127.0.0.1:8080/blog_system/blog_list.html");
        //2.点击查看全文按钮，进入到博客详情页
        driver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child(1) > a")).click();
        //进行一下显示等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //3.点击删除按钮进行删除博客
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(7)")).click();
        //4.对比一下跳转后的页面是不是详情页
        String curUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://127.0.0.1:8080/blog_system/blog_list.html",curUrl);
        //5.当前页面的第一篇博客名字已经不是被删除的博客名字了
        String curTitle = driver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child(1) > div.title")).getText();
        Assertions.assertTrue(!"自动化测试".equals(curTitle));
    }


    /**
     * 点击查看全文跳转到博客详情页
     * 博客标题和博客列表页的标题是匹配的
     */
    @Order(5)
    @ParameterizedTest
    @MethodSource()
    void BlogTitle(String blogUrl,String BlogTitle){
        //1.先跳转到博客列表页
        driver.get("http://127.0.0.1:8080/blog_system/blog_list.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //2.点击全文链接跳转
        driver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child(1) > a")).click();
        //显示等待一下
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //3.对比一下是博客的url，和博客标题,由于每个blogId都不一样所以用contains比较
        String  url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains(blogUrl));
        //拿到详情页的标题进行对比
        String title = driver.findElement(By.cssSelector("body > div.container > div.right > div > h3")).getText();
        Assertions.assertEquals(BlogTitle,title);

    }

    static Stream<Arguments> BlogTitle(){
        return Stream.of(Arguments.arguments("http://127.0.0.1:8080/blog_system/blog_detail.html?blogId=","这是第三篇博客"));
    }

    /**
     * 注销功能对应的测试，点击退出按钮，退回到登录页面
     */

    @Order(6)
    @Test
    void LogOut(){
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(6)")).click();
        //校验对应的Url
        //显示等待一下
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String curUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://127.0.0.1:8080/blog_system/blog_login.html",curUrl);
        //校验提交按钮
        String button = driver.findElement(By.cssSelector("#submit")).getAttribute("value");
        Assertions.assertEquals("提交",button);
    }

}

