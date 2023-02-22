import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-01-14
 * Time: 17:26
 */
public class TestDemo {
    public static void main1(String[] args) {
        //根据年龄打印当前年龄的人是少年(<18),青年(19-28)，中年(29-55),老年(56以上)
        Scanner scanner=new Scanner(System.in);
        int age=scanner.nextInt();
        if(age<=18){
            System.out.println("少年");
        }else if(age>18&&age<=28){
            System.out.println("青年");
        }else if(age>28&&age<=55){
            System.out.println("中年");
        }else if(age>=56){
            System.out.println("老年");
        }
    }

    public static void main2(String[] args) {
        //判定一个数字是否是素数
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int i;
        for(i=2;i<num;i++){//判断是否能被自身以及1以外的数字整除4
            if(num%i==0){
                break;
            }
        }
        if(i==num)//若num是素数，则执行到这里时候i==num，因为没有break过
        {
            System.out.println(num+"是素数");
        }else{
            System.out.println(num+"不是素数");
        }
    }

    public static void main3(String[] args) {
        //打印1-100之间所有的素数
        int num=1;
        int i;
        int count=0;//计数器
        while(num<=100){
            for( i=2;i<num;i++){//判断是否能被自身以及1以外的数字整除4
                if(num%i==0){
                    break;
                }
            }
            if(i==num){//若num是素数，则执行到这里时候i==num，因为没有break过
                System.out.println(num+" ");
                count++;
            }
            num++;
        }
        System.out.println("一共有"+count+"个素数");
    }

    public static void main4(String[] args) {
        //输出1000-2000之间所有的闰年
        int year=1000;
        int count=0;//计数器
        while(year<=2000){
            if(year%4==0&&year%100!=0){
                System.out.println(year);
                count++;
            }else if(year%100==0&&year%400==0){
                System.out.println(year);
                count++;
            }
            year++;
        }
        System.out.println("一共有"+count+"个闰年");
    }

    public static void main5(String[] args) {
        //输出乘法口诀表
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+j*i+"  ");
            }
            System.out.println();
        }
    }

    public static void main6(String[] args) {
        //求两个正整数的最大公约数
    }

    public static void main7(String[] args) {
        //计算1/1-1/2+1/3-1/4....+1/99-1/100
        int flag=-1;
        int i=1;
        double sum=0;
        while(i<=100){
            sum+= flag * (-1)* (1.0 / i);
            flag=-1*flag;//-1是交替出现的
            i++;
        }
        System.out.println(sum);
    }

    public static void main8(String[] args) {
//        编写程序数一下1-100所有整数中出现多少个数字9
        int i=1;
        int count=0;
        while(i<=100){
            if(i%10==9){//先看个位是不是9
                count++;
            }
            if(i/10==9){//再看十位是不是9
                count++;
            }
            i++;
        }
        System.out.println("一共有"+count+"个9");
    }

    public static void main9(String[] args) {
        //求出0-999之间的所有水仙花数
        int num=100;
        while(num<=999){
            if(num==(num%10)*(num%10)*(num%10)+(num/10%10)*(num/10%10)*(num/10%10)
                    +(num/100)*(num/100)*(num/100)){//满足此条件的为水仙花数
                System.out.println(num);
            }
            num++;
        }
    }

    public static void main10(String[] args) {
        //模拟密码输入
        String password="nawdswban98";
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入密码");
        String getpassword=scanner.nextLine();
        int i=1;
        while(i<3){
            if(getpassword==password)
            {
                System.out.println("登录成功");
                break;
            }
            if(getpassword!=password){
                System.out.println("请重新输入密码");
                getpassword=scanner.nextLine();
                i++;
            }
            if(i==3){
                System.out.println("退出程序");
            }

        }
    }

    public static void main11(String[] args) {
        //写一个函数二进制中1的个数

    }

    public static void main12(String[] args) {
        //获取一个数二进制序列中的所有偶数位和奇数位，分别输出二进制序列

    }

    public static void main13(String[] args) {
        //输出一个整数的每一位
        int num=3987678;
        do {
            System.out.println(num % 10 );
            num/=10;
        }while(num!=0);
    }

    public static void main(String[] args) {
        //完成猜数字游戏
        Random random = new Random();
        Scanner scanner=new Scanner(System.in);
        int rand= random.nextInt(100);
        while(true){
            System.out.println("请输入你猜的数字");
            int getrand=scanner.nextInt();
            if(rand>getrand){
                System.out.println("猜小了！");
            }else if(rand==getrand){
                System.out.println("猜对了!");
                break;
            }else{
                System.out.println("猜大了！");
            }
        }

    }
}
