package com.hj2022java.Junittest3;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 18:57
 */
//4.测试套件suite
    //这是一个测试套件，将我们所有的用例都执行起来
    //1.选择指定文件添加到套件中执行
   /* @Suite
    @SelectClasses({assesionTest.class, TestMethodOrderTest.class})*/
    //2.选择指定包添加到套件中执行
    //执行包下面所有以Test结尾的文件里面有@Test注解的用例
    @Suite
    @SelectPackages("com.hj2022java.Junittest3")
public class runAllSuite {

}
