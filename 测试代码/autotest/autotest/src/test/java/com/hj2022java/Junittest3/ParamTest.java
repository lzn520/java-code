package com.hj2022java.Junittest3;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.remote.Augmenter;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-08-20
 * Time: 19:04
 */
//5.参数化测试
    //不需要再添加@Test注解了，如果添加了，该用例会多执行一遍
public class ParamTest {


    //1>单参数 使用@ValueSource(类型s = {参数1，参数2。。。。。})
    @ParameterizedTest
    @ValueSource(strings = {"haha","kaka"})
    void singleParameter(String name){
        System.out.println("name："+name);
    }

    //2>多参数使用@CsvSource(value = {参数1，参数2....}),默认分隔符是逗号，可以用delimiterString来指定分隔符
    @ParameterizedTest
    @CsvSource(value = {"xixi,20","lucy,30"})
    void muchParameter(String name,int age){
        System.out.println("name: "+name+"  age: "+age);
    }

    //3>多参数如果参数特别多，可以使用文件注入的方式来添加
    @ParameterizedTest
    //指定文件为当前项目下resources下的csv文件
    @CsvFileSource(resources = "/my.csv")

    void  CSVfileTest(String name,int age){
        System.out.println("name: "+name+"  age: "+age);


    }

    @ParameterizedTest
    //6.动态参数
    //参数为数据来源的方法名，如果不指定数据来源，则默认找跟用例同名的static方法
    @MethodSource("demo")
    //单参数
    void dynamicTest(String x){
        System.out.println(x);
    }

    //定义提供数据的方法，返回值可以是stream流
    static Stream<String> demo(){
        return Stream.of("梨花","lucy");
    }

    @ParameterizedTest
    @MethodSource()
    //多参数
    void dynamicTest2(String name,int age){
        System.out.println("name: "+name+"  age: "+age);
    }

    static Stream<Arguments> dynamicTest2(){
        return Stream.of(Arguments.arguments("lucy",12),Arguments.arguments("梨花",29));
    }


}
