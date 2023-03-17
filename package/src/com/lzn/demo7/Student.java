package com.lzn.demo7;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-17
 * Time: 22:43
 */
/*public class Student implements Comparable<Student>{
    String name;
    int age;
    double score;

    public Student(String name, int age, double score) {//构造方法
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {//谁调用comparaTo谁就是this
        return this.age - o.age;
    }
}*/
public class Student {
    String name;
    int age;
    double score;

    public Student(String name, int age, double score) {//构造方法
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

}

class  AgeComparator implements Comparator<Student> {//通过年龄进行比较的比较器
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class  ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.score - o2.score);//由于年龄是double类型所以要强转成int
    }
}

class  NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}