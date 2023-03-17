package com.lzn.demo7;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-17
 * Time: 22:43
 */
/*public class Test {
    public static void main1(String[] args) {
        Student students1 = new Student("Amy",18,99.7);
        Student students2 = new Student("Max",17,86.7);

        System.out.println(students1.compareTo(students2));

    }
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Amy",18,99.7);
        students[1] = new Student("Max",17,86.7);
        students[2] = new Student("Cho",20,56.7);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

}*/
public class Test {

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Amy",18,99.7);
        students[1] = new Student("Max",17,86.7);
        students[2] = new Student("Cho",20,56.7);
        AgeComparator ageComparator = new AgeComparator();
        NameComparator nameComparator = new NameComparator();
        ScoreComparator scoreComparator = new ScoreComparator();
        Arrays.sort(students,ageComparator);//这个时候我们需要按照什么进行比较，就只需要多传一个比较器就好
        System.out.println(Arrays.toString(students));
    }

}