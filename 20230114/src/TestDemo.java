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
        if(age<18){
            System.out.println("少年");
        }else if(age>=18&&age<=28){
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
        for(i=2;i<num;i++){//判断是否能被自身以及1以外的数字整除4   改进用num/2  或者开根号num  变成<=
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
       // int year=1000;
        int count=0;//计数器
        /*while(year<=2000){
            if(year%4==0&&year%100!=0){
                System.out.println(year);
                count++;
            }else if(year%100==0&&year%400==0){
                System.out.println(year);
                count++;
            }
            year++;
        }*/
        for (int year = 1000; year < 2000 ; year++) {
            if (year % 100 !=0 && year % 4 == 0 || year % 400 == 0){
                System.out.println(year+"是闰年！");
            }
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
        //采用辗转相除法
        int a = 24;
        int b = 18;
        int c =a%b;
        while(c != 0){
            a = b;
            b = c;
            c = a%b;
        }
        System.out.println("最大公约数为"+b);

    }

    public static void main7(String[] args) {
        //计算1/1-1/2+1/3-1/4....+1/99-1/100
        int flag=1;
        int i=1;
        double sum=0;
        while(i<=100){
            sum+= flag * (1.0 / i);
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
        //1.先要求数字有多少位
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
        login();
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while(count != 0){
            System.out.println("请输入密码");
            String password=scanner.nextLine();
            if (password.equals("123456")){
                System.out.println("登录成功");
                break;
            }else{
                count--;
                System.out.println("登录失败,你还有"+count+"次机会");
            }
        }
    }
    public static void main11(String[] args) {
        //写一个函数二进制中1的个数
         int count=0;
         int num=-1;//要求二进制位中有多少个1的数字
        while(num!=0){//当num==0的时候二进制位全都是0了
            if((num&1)==1){//num与1按位与
                count++;
            }
            num=num>>>1;//无符号右移1位
        }
        System.out.println(count);
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

    public static void main14(String[] args) {
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

    public static void main15(String[] args) {
        //用异或找出只出现了一次的数字
        int[]  array={8,5,3,5,8};
        int sum=array[0];
        for(int i = 1;i < array.length;i++)
        {
            sum=sum^array[i];
        }
        System.out.println("只出现了一次的数字为"+sum);
    }

    public static int frogJump1(int n) {
        if(n == 1){   //递归结束条件
            return 1;
        }else if(n == 2){//递归结束条件
            return 2;
        }else {
            return frogJump1(n-1)+frogJump1(n-2);
        }
    }
   public static int frogJump2(int n){
        //非递归方式实现
       if(n==1){
           return 1;//当台阶为1时，只有一种跳台阶的方式
       }else if(n==2){
           return 2;//当台阶为2时，只有两种跳台阶的方式
       }

        int f1 = 1;
        int f2 = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {//i表示台阶数
             cur = f1 + f2;//cur表示的是当前台阶有几种跳台阶方式
             f1 = f2;
             f2 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入台阶的个数");
        int n= scan.nextInt();//用n来接收台阶的个数
        int num=frogJump2(n);//跳台阶的方式用num接收
        System.out.println(n+"阶台阶一共有"+num+"种跳台阶方式");
    }
    //汉诺塔问题
   /**
    * n表示汉诺塔的盘子个数
    * pos1表示的是盘子起始位置
    * pos2表示的是盘子中转位置
    * pos3表示的是盘子终点位置
    **/
   public static void move(char pos1,char pos2) {
       System.out.print(pos1+"->"+pos2+" ");//将pos1处的盘子移动到pos2位置
   }
    public static void  hannoi(int n,char pos1,char pos2,char pos3) {
        if(n == 1){
            move(pos1,pos3);//当只有一个盘子的时候将这一个盘子直接移动到pos3位置
        }else{
            hannoi(n-1,pos1,pos3,pos2);//将除了最底下的盘子的其他盘子通过中转pos3移动到pos2
            move(pos1,pos3);//将最底下的盘子移动到pos3
            hannoi(n-1,pos2,pos1,pos3);//将剩下的n-1个盘子通过pos1中转移动到pos3
        }

    }
    public static void main18(String[] args) {
        hannoi(1,'A','B','C');
        System.out.println();
        hannoi(2,'A','B','C');
        System.out.println();
        hannoi(3,'A','B','C');

    }
}
