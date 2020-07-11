package iu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class JavaBase50 {

    /**
     * 题目一：
     * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
     * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？
     */
    /**
     * 1
     * 1+0=1
     * 1+1=2
     * 2+1=3
     * 3+2=5
     * 5+3=8
     * 8+5=13
     * 13+8=21
     * 第一个月1 。第二个月 1 。 第三个月2 。第四个月的时候这两对兔子只有一对可以繁殖，所以为3 。
     * 第五个月的时候现有的3对兔子中有两对可以繁殖。故为3+2=5 。第六个月的时候5对兔子的基础上有3对兔子又可以繁殖。故有5+3=8对兔子。
     * 也就是说，第n个月的时候，会有S(n)=C(n)+C(n-2)对兔子。C(n)=C(n-1)+C(n-2)
     */
    //求得所需月份的兔子的数量，返回值为兔子的数量
    private static int fun(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fun(n - 1) + fun(n - 2);
        }
    }

    private static void func_01() {
        System.out.println("请输入想要计算的月份：");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int count = fun(Integer.parseInt(input));
        System.out.println("第" + input + "个月的兔子数量为：" + count);
    }


    /**
     * 题目二：判断101-200之间有多少个素数，并输出所有素数。
     */
    /*
    要判断是不是素数，需要判断这个数是否能被i++整除
     */
    public static void func_02() {

        for (int i = 101; i <= 200; i++) {
            boolean isNum = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isNum = true;
                }
            }
            if (isNum == false) {
                System.out.println(i);
            }
        }

    }

    /**
     * 题目三：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
     * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
     */
    /*
    //先来解决一个数
    int n = 456;
    int a = n/100;
    int b = (n%100)/10;
    int c = (n%100)%10;
    System.out.println(a+","+b+","+c);
     */
    private static void func_03() {
        for (int i = 100; i < 999; i++) {
            int m = i / 100;
            int n = (i % 100) / 10;
            int k = (i % 100) % 10;
            if (i == m * m * m + n * n * n + k * k * k) {
                System.out.println(i);
            }
        }
    }

    /**
     * 题目四：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     */
    /*
    程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
    (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
    (2)如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步。
    (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
     */
    private static void func_04() {
        /*
        想一下，如果我想把90分解质因数的话。我要怎么做
        90/2看能除尽不。能的话。45除以2看能除尽不，不能。不能的话45/3看能除尽不.能。15/2看能除尽不。不能。
        那么再除以3 。能。剩余5。除以2 。不行，然后除以3 。 不行。再除以5 。已经是他本身了。输出，那么得到了2 3 3 5

        那么我如果想要分解205的话
        205/2 不行。205/3 不行。205/5=41 那么41/2  41/2 不行 41/3 不行 41/5 不行 41/7不行
        这么说的话好像是。41/1 2 3 4 5 6 7 8 9 10 都不行。
        也就是说。我看一个数能不能被最小质因数整除也就是意思是看他能不能被所有的比他小的整数挨个试一遍
         */

        /*
        质数：只能被1和它本身整除
        其他的数：除了1和它本身还能被其他的数整除。
        如果我想分解24  最小质因数的话。就不是2 2 2 3
        如果我想分解260
        除以2 可以 留下 除以3不行pass 除以4不行pass 除以5可以留下 除以2可以留下 剩下13了。
        除以2 3 4 5 6 7 8 9 10 11 12都不行。13等于自己。留下输出结束
         */
        System.out.println("请输入需要分解的正整数：");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int i = 2; i < input + 1; i++) {

            /**
             * 此处要注意if和while的不同  if只判断一次。而while会不停地判断，直到条件不成立才停止
             */

            /*if(input%i == 0 && input != i){
                input = input/i;
                System.out.print(i+"*");
            }*/
            while (input % i == 0 && input != i) {
                input = input / i;
                System.out.print(i + "*");
            }
            if (input == i) {
                System.out.print(i);
                break;
            }


        }


    }

    /**
     * 题目五：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
     */

    public static void func_05() {

        System.out.println("请输入成绩：");

        Scanner scanner = new Scanner(System.in);
        double score = scanner.nextDouble();
        String review = "";
        review = score > 90 ? "A" : (score < 60 ? "C" : "B");

        System.out.println("成绩评价为：" + review);

    }

    /**
     * 【程序6】
     * <p>
     * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
     */

    public static void func_06() {
        /*
        要求两个数的最大公约数和最小公倍数，我们先求最大公约数。
        最大公约数的算法。1.我们先用大的数对小的数求余 。 2.余数作为小的。刚刚小的数赋给大的继续。3.到最后余数为0的时候，上一步的求余结果就是最大公约数
        最小公倍数的算法：在知道最大公约数的基础上。multiple=input1*input2/bigDIvisor
         */
        System.out.println("请输入两个数，中间用" + "#" + "隔开:");
        String[] arr = new String[2];
        Scanner scanner = new Scanner(System.in);
        arr = scanner.next().split("#");
        if (arr.length == 2) {

            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int input1 = a;
            int input2 = b;
            if (a > b) {
                int c = b;
                b = a;
                a = c;
            }
            while (a < b && a != 0) {
                int temp = a;
                a = b % a;
                b = temp;
            }
            if (a == 0) {
                System.out.println("最大公约数为：" + b);
            }
            int multiple = input1 * input2 / b;
            System.out.println("最小公倍数为：" + multiple);
        }


    }

    /**
     * 【程序7】
     * <p>
     * 题目：输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数。
     */
    public static void func_07() {
        /*
        1、获取一行字符串，nextLine（）
        2、把字符串的每一个字符赋值到一个数值中
        3、对比每一个数值在ASK码的范围，就可以确定它符号的类别
        4、char字符ASK码的范围
        （1）数字0到9：48~57
        （2）字母A到Z：65到90 a到z：97到122
        （3）空格是32
         */
        System.out.println("请输入要进行统计的字符串：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int letter = 0;
        int number = 0;
        int blank = 0;
        int other = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 48 && chars[i] <= 57) {
                number++;
            } else if ((chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <= 122)) {
                letter++;
            } else if (chars[i] == 32) {
                blank++;
            } else {
                other++;
            }
        }
        System.out.println(letter + " " + number + " " + blank + " " + other);

    }

    /**
     * 【程序8】
     * <p>
     * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
     * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。输出结果的形式如：2+22+222=246；
     */
    /*
    想一下。2 2+2*10 2+2*10+2*100 2+2*10+2*100+2*1000
     */
    public static void func_08() {

        System.out.println("请输入a的值：");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt();
        System.out.println("请输入要累加的次数n:");
        Scanner scanner1 = new Scanner(System.in);
        int n = scanner1.nextInt();
        double sum = 0;
        double num = 0;
        int i = 0;
        while (i < n) {
            i++;
            sum = sum + a;
            a = 2 * Math.pow(10, i);
            if (i < n) {
                System.out.print(sum + "+");
            }
            if (i == n) {
                System.out.print(sum + "=");
            }
            num += sum;
        }
        System.out.print(num);

    }

    /**
     * 【程序9】
     * 题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。
     * 判断完数的方法：
     *   利用for循环判断所有因数的和是否和输入的值是否相等，相等的话输出
     *   求因数的方法：
     *   （1）两个嵌套循环，并用i%j==0,关于i和j的值范围：i从1到1000逐个遍历，j只需不大于i/2+1即可
     *   比如：48，最大的因数才24,99最大的因数是33，因数不会大于本身数的一半
     *   （2）j就是我们所求的因数，把所有的j相加，就可以得到因数总和
     *   （3）因数总和已经包含1了，因为第一次就保存1了
     */
    /*
    先判断是不是因数，怎么判断呢，取余等于0就是因数。但不必循环到最后一位。一半就好了
    然后再判断所有的因数加起来是不是正好等于这个数
     */
    public static void func_09() {
        //思路清晰一点 来，先求一个数的因数
        //再放到循环里面
        for (int i = 1; i < 1000; i++) {
            //System.out.println();
            //System.out.print(i+"的全部因子为：");
            if (i >= 2) {
                int sum = 0;
                String express = "";
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0 && i != j) {
                        //System.out.print(j+" ");
                        sum += j;
                        express = express + String.valueOf(j) + "+";
                    }
                }
                if (i == sum) {
                    System.out.println(i + "为完数");
                    System.out.println(express.substring(0, express.length() - 1) + "=" + i);
                }
            } else {
                System.out.println("1为完数");
                System.out.println("1=1");
            }
        }
    }

    /**
     * 【程序10】
     * <p>
     * 题目：一球从h米高度自由落下，每次落地后反跳回原高度的一半；
     * 再落下，求它在 第n次落地时，共经过多少米？第n次反弹多高？
     */
    public static void func_10() {
        /*
        我们假设初始高度为1，第1次落下，弹起高度为1/2，那么高度应该是1 1/2 1/4 1/8
        也就是说。第n次的高度为1/2的n次方。昨天的那个函数还记得吗？Math.pow(1/2,n)-----这样写竟然会错。需要Math.pow(0.5,n)
         */
        System.out.println("请输入第n次落下的n的数值：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 0;
        double heigt = 1;

        for (int i = 0; i < n; i++) {
            sum += heigt;
            heigt = Math.pow(0.5, i + 1);
            System.out.println("第n次反弹的高度为：" + heigt + "米");
        }
        System.out.println("共经过了" + sum + "米");

    }

    /**
     * 【程序11】
     * <p>
     * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     */
    public static void func_11() {
        /*int[] arr = {1,2,3,4};

        //一共有4*3*2种可能，一共需要去4*3*2*3个数字。
        int i = 0;
        while(i<12){
            int index = (int)(Math.random() * arr.length);
            int randNum = arr[index];
            i++;
            System.out.print(randNum+" ");
        }*/
        /*
        上面的这种想法就错误的。不能这么想
         */
        /*
        1234组成的最大的3位数为432  而最小的3位数为123
        所以，应该是在123-234这些数中取几个出来。互相之间不等就好了。
        需要注意，这些数字之间不能重复出现
         */
        int count = 0;
        for (int i = 123; i < 433; i++) {
            int firstNum = i / 100;
            int secondNum = (i % 100) / 10;
            int thirdNum = i % 10;

            if (firstNum == 0 || firstNum > 4) {
                continue;
            }
            if (secondNum == 0 || secondNum > 4) {
                continue;
            }
            if (thirdNum == 0 || thirdNum > 4) {
                continue;
            }
            if (firstNum != secondNum && firstNum != thirdNum && secondNum != thirdNum) {
                System.out.print(firstNum);
                System.out.print(secondNum);
                System.out.print(thirdNum);
                System.out.println();
                count++;
            }
        }
        System.out.println(count);

        //还行。这个代码虽然嵌套3层for循环不好看但简单的解决问题。可以
        /*int sum = 0;
        for (int bite = 1; bite < 5; bite++) {
            for (int ten = 1; ten < 5; ten++) {
                for (int hundred = 1; hundred < 5; hundred++) {
                    if (bite != ten && bite != hundred && ten != hundred) {//符合条件的数字
                        System.out.print((hundred * 100 + ten * 10 + bite) + "  ");
                        sum++;//计算个数
                        if (sum % 10 == 0) {//十个一行
                            System.out.println();
                        }
                    }
                }
            }
        }
        System.out.println("\n总共有：" + sum + "个这样的数");*/
    }

    /**
     * 【程序12】
     * <p>
     * 题目：企业发放的奖金根据利润提成。
     * 利润(I)低于或等于10万元时，奖金可提10%；
     * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
     * 20万到40万之间时，高于20万元的部分，可提成5%；
     * 40万到60万之间时高于40万元的部分，可提成3%；
     * 60万到100万之间时，高于60万元的部分，可提成1.5%，
     * 高于100万元时，超过100万元的部分按1%提成，
     * 从键盘输入当月利润I，求应发放奖金总数？
     */
    public static void func_12() {

        /*
        分析：
        分阶段。判断是属于哪个阶段。数组。里面写这个分界线。然后对应起来后面的比例。所以创建两个数组吧。
         */
        System.out.println("请输入当月的利润I的值：");
        Scanner scanner = new Scanner(System.in);
        double profit = scanner.nextDouble();
        int[] arr1 = {10, 20, 40, 60, 100};
        double[] arr2 = {0.1, 0.075, 0.05, 0.03, 0.015, 0.01};
        double[] certainPro = {10 * 0.1, 10 * 0.075, 20 * 0.05, 20 * 0.03, 40 * 0.015};
        double bonus = 0;
        int[] rank = {0, 1, 2, 3, 4, 5, 6};
        int level = profit > 100 ? 6 : (profit > 60 ? 5 : (profit > 40 ? 4 : (profit > 20 ? 3 : (profit > 10 ? 2 : 1))));
        switch (level) {
            case 1:
                bonus = profit * arr2[0];
                break;
            case 2:
                bonus = certainPro[0] + (profit - arr1[0]) * arr2[1];
                break;
            case 3:
                bonus = certainPro[0] + certainPro[1] + (profit - arr1[1]) * arr2[2];
                break;
            case 4:
                bonus = certainPro[0] + certainPro[1] + certainPro[2] + (profit - arr1[2]) * arr2[3];
                break;
            case 5:
                bonus = certainPro[0] + certainPro[1] + certainPro[2] + certainPro[3] + (profit - arr1[3]) * arr2[4];
                break;
            case 6:
                bonus = certainPro[0] + certainPro[1] + certainPro[2] + certainPro[3] + certainPro[4] + (profit - arr1[4]) * arr2[5];
                break;
        }
        System.out.println(bonus);

    }

    /**
     * 【程序13】
     * <p>
     * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
     */
    public static void func_13() {

        for (int i = 0; i < 100000; i++) {
            if (Math.sqrt(i + 100) == (long) Math.sqrt(i + 100) && Math.sqrt(i + 268) == (long) Math.sqrt(i + 268)) {
                System.out.println(i);
            }
        }

    }

    /**
     * 【程序14】
     * <p>
     * 题目：输入某年某月某日，判断这一天是这一年的第几天？
     */
    public static void func_14() {

        System.out.println("请输入日期，格式如：2020-05-20：");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        int ans = 0;
        int february = 0;
        if (year % 4 == 0) {
            february = 29;
        } else {
            february = 28;
        }
        switch (month) {
            case 1:
                ans = day;
                break;
            case 2:
                ans = 31 + day;
                break;
            case 3:
                ans = 31 + february + day;
                break;
            case 4:
                ans = 31 + february + 31 + day;
                break;
            case 5:
                ans = 31 + february + 31 + 30 + day;
                break;
            case 6:
                ans = 31 + february + 31 + 30 + 31 + day;
                break;
            case 7:
                ans = 31 + february + 31 + 30 + 31 + 30 + day;
                break;
            case 8:
                ans = 31 + february + 31 + 30 + 31 + 30 + 31 + day;
                break;
            case 9:
                ans = 31 + february + 31 + 30 + 31 + 30 + 31 + 31 + day;
                break;
            case 10:
                ans = 31 + february + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
                break;
            case 11:
                ans = 31 + february + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
                break;
            case 12:
                ans = 31 + february + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
                break;
        }
        System.out.println(ans);
    }

    /**
     * 【程序15】
     * <p>
     * 题目：输入三个整数x,y,z，请把这三个数由小到大输出。
     */
    public static void func_15() {
        System.out.println("请输入三个数用','隔开：");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] arr = next.split(",");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        int z = Integer.parseInt(arr[2]);
        //xyz xzy yxz yzx zxy zyx
        String order = x > y ? (x > z ? (y > z ? "xyz" : "xzy") : "zxy") : (x > z ? "yxz" : (y < z ? "zyx" : "yzx"));
        String desc = x < y ? (x < z ? (y < z ? "xyz" : "xzy") : "zxy") : (x < z ? "yxz" : (y < z ? "zyx" : "yzx"));

        char[] c = desc.toCharArray();
        int firstNum = c[0] == 'x' ? x : (c[0] == 'y' ? y : z);
        int secondNum = c[1] == 'x' ? x : (c[1] == 'y' ? y : z);
        int thirdNum = c[2] == 'x' ? x : (c[2] == 'y' ? y : z);

        System.out.println(firstNum + " " + secondNum + " " + thirdNum);
    }

    /**
     * 【程序16】
     * <p>
     * 题目：输出9*9口诀。
     */
    public static void func_16() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    System.out.println(j + "*" + i + "=" + i * j + " ");
                } else {
                    System.out.print(j + "*" + i + "=" + i * j + " ");
                }
            }
        }
    }

    /**
     * 【程序17】
     * <p>
     * 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个。第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     */
    public static void func_17() {

        //后一天等于前一天的0.5倍-1
        //第十天的数量也等于前一天的0.5倍-1
        //第十天的数量是1 。 那么第九天的数量是(1+1)/0.5
        //也就是说。前一天的数量是后一天的数量+1然后再除以0.5 既然这样的话。是吃了9天对吗。是的9天。
        int sum = 0;
        double count = 1;
        for (int i = 9; i > 0; i--) {
            System.out.println("吃了" + i + "天之后剩余的数量为：" + count);
            sum += count;
            count = (count + 1) / 0.5;


        }
        System.out.println(sum);
        /*
        程序分析：采取逆向思维的方法，从后往前推断。
        天  数      1   2    3    4   5    。。。10
        桃子数     1    4   10   22   46          ？
        所以桃子数计算方法：前一天桃子数*2+2
         */

        /*int sum=1;//第一天桃子的数量
        for (int i =2; i <=10;i++) {//第二天才开始计算
            sum=sum*2+2;
        }
        System.out.println("猴子摘的桃子数为："+sum);*/


    }

    /**
     * 【程序18】
     * <p>
     * 题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。
     * 有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
     */
    public static void func_18() {
        /*
        总共也没几种可能吧，全列出来也没多少：ax ay az bx by bz cx cy cz
        ax cx cz排除,剩余ay az bx by bz cy
        既然已经确定了cy 那么by ay排除。
        那不就剩下az bz cy bx
        a不和x比 而y已经确定了和c比。所以。a只能和z比。那么b就不能和z比。
        就剩下 az bx cy
        分析一波程序都不用写就出来答案了。哈哈哈哈哈
         */
        char[] c1 = {'a', 'b', 'c'};
        char[] c2 = {'x', 'y', 'z'};
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if ((c1[i] == 'a' && c2[j] == 'x') || (c1[i] == 'c' && c2[j] == 'x') || (c1[i] == 'c' && c2[j] == 'z')) {

                } else {
                    if ((c1[i] == 'b' && c2[j] == 'y') || (c1[i] == 'a' && c2[j] == 'y')) {

                    } else {
                        if ((c1[i] == 'b' && c2[j] == 'z')) {

                        } else {
                            System.out.println(c1[i] + " " + c2[j]);
                        }
                    }
                }
            }
        }
    }

    /**
     * 【程序19】
     * <p>
     * 题目：打印出如下图案（菱形）
     * <p>
     * *
     * ***
     * ******
     * ********
     * ******
     * ***
     * *
     */
    public static void func_19() {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i - 3; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 【程序20】
     * <p>
     * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
     */
    public static void func_20() {
        float up = 2;//分子
        float down = 1;//分母
        float fraction = up / down;//分数
        float temp = 0;//交换数
        float sum = 0;//总和
        for (int i = 0; i < 20; i++) { //前面20项
            sum += fraction;//分数相加
            temp = up + down;//先把分子分母的和赋值给一个交换数，不能马上赋值给分子，因为分子的值下面还有用
            down = up;//把分子的值赋值给下一下的分母
            up = temp;//把交换数的值赋值给下一项分子
            fraction = up / down;//下一项的分数值 }

            System.out.println("" + sum);
        }
    }


    /**
     * 【程序21】
     *
     * 题目：求1+2!+3!+...+20!的和
     *
     * 程序分析：此程序只是把累加变成了累乘。
     *
     *          1、先求该项阶乘的值
     *
     *       *   2、累加求和
     */
    public static void func_21(){
        long sum = 0;
        for (int i = 1; i < 21; i++) {
            long product = 1;
            for (int j = 1; j < i+1; j++) {

                product *= j;
            }
            System.out.println(product);
            sum+=product;
        }
        System.out.println(sum);

    }

    /**
     * 【程序22】
     *
     * 题目：利用递归方法求5!。
     *
     * 程序分析：递归公式：f(n)=n*f(n-1)
     *
     *      不断的调用方法，直到最小的值确定
     */
    public static int func_22(int n){
        if(n == 1){
            return 1;
        }
        return n * func_22(n-1);
    }

    /**
     * 【程序23】
     *
     * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。
     * 问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
     */
    public static void func_23(){
        System.out.println(10+2+2+2+2);
    }
    //递归方法求第五个人的岁数
    private static int func_23_2(int num, int ageMore) {
        if (num == 1) {//第一个人岁数为10
            return 10;
        }
        return func_23_2(num - 1, ageMore) + ageMore;//每上一个人岁数加2
    }

    /**
     * 【程序24】
     *
     * 题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
     *
     * 程序分析：创建一个五位数数的数组，把输入数字的每位数的值赋值到数组里面  
     *
     *       * 把输入 数字从个位起获取，并且每获取一次之后/10，这样就能分别获取十位百位千位了
     *
     *       * 把数字打印出来就是题目所求了
     */
    public static void func_24() {
        System.out.println("请输入一个不大于5位数的数字：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();//获取输入
        int[] arr = new int[5];//创建5位数的数组
        int i = 0;
        //循环取位
        do {
            arr[i] = num % 10;
            num = num / 10;
            i++;
        } while (num != 0);//只剩下一位时，说明获取完毕，跳出循环
        System.out.println("输入数字串的是" + i + "位数的");
        System.out.println("逆序输出：");
        //打印出数组
        for (int j = 0; j < i; j++) {
            System.out.print(arr[j] + "  ");
        }
        scanner.close();
    }

    /**
     * 【程序25】
     *
     * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
     *
     * 这个程序跟上一个程序类似。
     *
     *       * 创建一个五位数的数组
     *
     *       * 逐次取位
     *
     *       * 组后判断条件就可以了
     */
    public static void func_25() {

        System.out.println("请输入一个五位数：");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();//获取输入的数字
        int arr[] = new int[5];//创建一个大小为5的数组
        int i = 4;
        do {//逐次取位
            arr[i] = input % 10;
            input /= 10;
            i--;
        } while (i >= 0);//这里的结束条件写input！=0也是可以的
        //System.out.println(Arrays.toString(arr));
        if (arr[0] == arr[4] && arr[1] == arr[3]) {
            System.out.println("输入的数是回文数字！");
        } else {
            System.out.println("输入的数不是回文数字！");
        }
        scanner.close();
    }


    /**
     * 【程序26】
     *
     * 题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。
     *
     * 程序分析：用情况语句比较好，如果第一个字母一样，则判断用情况语句或if语句判断第二个字母。
     */
    public static void func_26() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String input2 = "";
        switch (input) {
            case "m":
                System.out.println("Monday");
                break;
            case "t":
                System.out.println("请输入第二个字母：");
                input2 = scanner.next();
                if (input2.equals("u")) {
                    System.out.println("Tuesday");
                } else if (input2.equals("h")) {
                    System.out.println("Thursday");
                } else {
                    System.out.println("你输入的字母有误！");
                }
                break;
            case "w":
                System.out.println("Wednesday");
                break;
            case "f":
                System.out.println("Friday");
                break;
            case "s":
                System.out.println("请输入第二个字母：");
                input2 = scanner.next();
                if (input2.equals("u")) {
                    System.out.println("Sunday");
                } else if (input2.equals("a")) {
                    System.out.println("Saturday");
                } else {
                    System.out.println("你输入的字母有误！");
                }
                break;
            default:
                System.out.println("你输入的字母不正确！");
                break;
        }
        scanner.close();
    }

    /**
     * 【程序27】
     *
     * 题目：求100之内的素数
     *
     * 素数的判断方法：这个数除以2到比它本身少1的数都不能整除，那么这个数就是素数了！
     */
    public static void func_27(){

        for (int i = 1; i < 100; i++) {
            boolean ans = true;
            for (int j = 2; j < i; j++) {
                if(i%j == 0){
                    ans=false;
                }
            }
            if (ans == true){
                System.out.println(i);
            }

        }

    }

    /**
     * 【程序28】
     *
     * 题目：对10个数进行排序
     *
     * 程序分析：可以利用选择法，即从后9个比较过程中，选择一个最小的与第一个元素交换，下次类推，即用第二个元素与后8个进行比较，并进行交换。
     *
     * 最后打印出来的数组就是从小到大排列的数组了
     */
    public static void func_28(){
        System.out.println("请输入10个数，中间用逗号空格分隔开：");
        int [] arr = new int[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < 9; i++) {
            int temp=0;//交换数
            for (int j = i+1; j < arr.length-i; j++) {
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("排列后的数组："+ Arrays.toString(arr));//Arrays类的包装方法！
    }


    public static void func_28_2() {
        int[] arr = {1, 4, 5, 7, 2, 3, 9, 6};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * 【程序29】
     *
     * 题目：求一个3*3矩阵对角线元素之和
     *
     * 程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。
     */
    public static void func_29() {
        System.out.println("请输入九个数字：");
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[3][3];
        //获取矩阵数字
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("第一条对角线之和：" + (arr[0][0] + arr[1][1] + arr[2][2]));
        System.out.println("第二条对角线之和：" + (arr[0][2] + arr[1][1] + arr[2][0]));
        scanner.close();
    }


    /**
     * 【程序30】
     * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
     * 程序分析：首先判断此数是否大于最后一个数，然后再考虑插入中间的数的情况，插入后此元素之后的数，依次后移一个位置。
     * 1、创建两个数组，如果插入的数字比数组最后一个都大，那么插入的数放在新数组最后就可以
     * 2、如果插入的不是最大，那么和数组前面的数逐一比较，比较到比插入的数大就break
     * 比如第i个符合条件，那么arrB[i-1]=arrA[i-1],arrB[i]=num,arrB[i+1]=arrA[i]
     */
    public static void func_30(){
        int [] arr = {1,3,5,7,9};
        int [] arr2 = new int[arr.length+1];
        System.out.println("请输入要插入的数：");
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        if(nextInt > arr[arr.length-1]) {
            arr2 = arr;
            arr2[arr.length] = nextInt;
        }else {
            for (int i = 0; i < arr.length; i++) {
                if(nextInt > arr[i]){
                    arr2[i] = arr[i];
                    if (nextInt <arr[i+1]) {
                        arr2[i+1] = nextInt;
                    }
                    continue;
                }
                arr2[i + 1] = arr[i];
            }
        }
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        for(int b:arr2){
            System.out.print(b+" ");
        }
    }

    /**
     * 题目：将一个数组逆序输出。
     *
     * 程序分析：用第一个与最后一个交换。
     */
    public static void func_31(){

        int [] arr = {1,4,5,2,3,1,3,4,7,6};
        if(arr.length%2 == 0){
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = 0;
                temp = arr[arr.length-i-1];
                arr[arr.length-i-1] = arr[i];
                arr[i] = temp;
            }

        }else {
            for (int i = 0; i < arr.length / 2 + 1; i++) {
                if(i != arr.length-i-1){
                    int temp = 0;
                    temp = arr[arr.length-i-1];
                    arr[arr.length-i-1] = arr[i];
                    arr[i] = temp;
                }

            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    /**
     * 【程序32】
     *
     * 题目：取一个整数a从右端开始的4～7位。
     *
     */
    public static void func_32(){

        String a = "123456789";
        System.out.println(a.length());
        //要取从右端开始的4到7位。简单啊。用substring就可以实现
        //a.length()是全长度，最后一位数组的下标是a.length()-1，那么倒数第四位的下边是a.length()-4，那么倒数第4位的下标是a.length()-7
        String substring = a.substring(a.length() - 7, a.length() - 1);

        //我要截取第一位
        System.out.println(a.substring(0,1));
        //我要截取第二位
        System.out.println(a.substring(1,2));
        //我要截取最后一位
        //也就是我要截取第九位  那意味着我第一个参数的值要等于8 第二个参数的值要等于9
        System.out.println(a.substring(a.length()-1,a.length()));
        //那我要截取倒数第2位的意思就是我要截取第8位，那我要第一个参数的值等于7，第二个参数的值等于8
        System.out.println(a.substring(a.length()-2,a.length()-1));
        //我要截取第3位到第6位的话就是
        System.out.println(a.substring(3,6));
        //那我要截取右边的第4位的话就是我要截取左数的a.length()-4+1位。那我的长度
        System.out.println(a.substring(a.length()-4,a.length()-4+1));
        //那我要截取倒数第7位的话就是要截取a.length()-7+1位，那我的第一个值要等于a.length-7，第2个值要等于a.length-7+1
        System.out.println(a.substring(a.length()-7,a.length()-7+1));
        //
        System.out.println(a.substring(a.length()-7,a.length()-4+1));


        //所以要截取第n位的话就是a.substring(n-1,n)
        //要截取倒数n位的话就是a.substring(a.length()-n,a.length()-n+1);
        //要截取n到m位的话就是a.substring(n,m)
        //要截取倒数m到n位的话就是a.substring(a.length(n),a.length()-m+1);


    }

    /**
     * 【程序33】
     *
     * 题目：打印出杨辉三角形（要求打印出10行如下图）
     *
     * 程序分析：
     *
     *      1
     *     1 1
     *    1 2 1
     *   1 3 3 1
     *  1 4 6 4 1
     * 1 5 10 10 5 1
     */
    public static void func_33(){
        int[][] arr = new int[10][10];
        //我想要让a[i][0] = 1
        for (int i = 0; i < 10; i++) {
            arr[i][0] = 1;
        }
        //其他的数字。有这样的关系 a[i][j]+a[i][j+1] = a[i+1][j+1]
        //因为第一列的数字已经定了。第一行的数字也已经定了。所以从1开始到10。循环9次就够了
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i+1; j++) {
                arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
            }
        }
        //打印输出
        for (int i = 0; i < arr.length; i++) {
            //arr.length为10 。 从0到9就是10个数
            //我们先需要打印输出空格，空格的个数显然是越来越少的。
            for (int j = arr.length-i; j > 0 ; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < arr.length; k++) {
                if(arr[i][k] != 0){
                    System.out.print(arr[i][k] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 【程序34】
     *
     * 题目：输入3个数a,b,c，按大小顺序输出。
     */
    public static void func_34(){

        System.out.println("请输入3个数，中间用空格分隔开：");
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= scanner.nextInt();
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j]<arr[j+1]){
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    /**
     * 【程序35】
     *
     * 题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
     */
    public static void func_35(){

        int[] arr = {5, 6, 0, 1, 3, 4};
        int [] arr1 = arr.clone();
        /*
        先循环找到最大的一个数放到第一位
        再拿这个数字与数组中的元素比较看和哪个相等，然后记录下标
        同理找到最小的，
        然后再看这个数字和数组中的元素哪个相等，然后记录下标
        然后再替换。
         */
        //先来找最大的数字
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                /*int temp = 0;
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i+1] = temp;*/
                int temp = 0;
                temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
        }
        int maxValue = arr[arr.length - 1];
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
        //System.out.println(maxValue);
        //再来找出最小数字
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<arr[i+1]){
                int temp = 0;
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i+1] = temp;
            }
        }
        int minValue = arr[arr.length - 1];
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
        //System.out.println(minValue);
        /*for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }*/
        //现在需要找出值相等的那个下标
        int maxSequence = 0;
        int minSequence = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] == maxValue){
                maxSequence = i;
            }
            if(arr1[i] == minValue){
                minSequence = i;
            }
        }
        System.out.println(maxSequence + " "+minSequence);

        int temp1 = arr1[0];
        int temp2 = arr1[arr.length-1];
        arr1[0] = arr1[maxSequence];
        arr1[arr.length-1] = arr1[minSequence];
        arr1[maxSequence]=temp1;
        arr1[minSequence] = temp2;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] +" ");
        }

    }

    /**
     * 【程序36】
     *
     * 题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
     */
    public static void func_36(){
        int[] arr ={5,2,0,1,3,4};
        //懒得弄了。直接假设m的值为3
        int[] tempM = new int[3];
        for (int i = 0; i < 3; i++) {
            tempM[i] = arr[i+3];
            arr[i+3]=arr[i];
            arr[i] = tempM[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }


    /**
     * 【程序37】
     *
     * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
     */
    public static void func_37() {
        System.out.print("请输入一个整数：");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        //定义数组变量标识某人是否还在圈内
        boolean[] boolArr = new boolean[n];
        for (int i = 0; i < boolArr.length; i++) {
            boolArr[i] = true;
        }
        int inCount = n;//定义圈内人数
        int countNum = 0;//定义报数
        int index = 0;//定义索引
        while (inCount > 1) {//最后一人时退出循环
            if (boolArr[index]) {//判断下一个人是否在圈内
                countNum++;//在的话报数
                if (countNum == 3) {//如果这个数等于3
                    boolArr[index] = false;//把他定义为出圈
                    countNum = 0;//报数清零，下一个好从1开始
                    inCount--;//圈内人数减一
                }
            }
            index++;//下一人的位置索引值
            if (index == n) {//当索引到最后之后再从头开始
                index = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (boolArr[i]) {//最后只有一个符合条件的
                System.out.println("留下的是：" + (i + 1));
            }
        }
    }

    /**
     * 【程序38】
     *
     * 题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
     */
    public static void func_38(){
        System.out.println("请输入一串字符：");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();//获取输入的字符串
        System.out.println("你输入的字符串是："+input);
        System.out.println("你输入的字符串长度是："+input.length());
        scanner.close();
    }

    /**
     * 【程序39】
     *
     * 题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n(利用指针函数)
     */
    public static void func_39(double n) {
        System.out.println("请输入一个整数：");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        double sum = 0;//总和
        if (input % 2 == 0) {//偶数
            for (double i = 2; i <= input; i += 2) {
                sum += 1 / i;
                if (i == input) {
                    System.out.print("1/" + (int) i);//输出最后一项，最后用break，中断后面的执行
                    break;
                }
                System.out.print("1/" + (int) i + " + ");//输出相加的项后面加个加号 
            }
        } else {//奇数情况
            for (double i = 1; i <= input; i += 2) {
                sum += 1 / i;
                if (i == input) {
                    System.out.print("1/" + (int) i);//输出最后一项，最后用break，中断后面的执行
                    break;
                }
                System.out.print("1/" + (int) i + " + ");//输出相加的项后面加个加号
            }
        }
        System.out.println(" = " + sum);
        scanner.close();
    }

    /**
     *【程序40】
     *
     * 题目：字符串排序。
     */
    public static void func_40() {
        String[] str = {"abc", "cad", "m", "fa", "f"};
        /*for (int i = str.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (str[j].compareTo(str[j + 1]) > 0) {
                    String temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
                }
            }
        }*/
        for (int i = 1; i < str.length; i++) {
            for (int j = 0; j < str.length - i; j++) {
                if (str[j].compareTo(str[j + 1]) > 0) {
                    String temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
                }
            }
        }
        for (String subStr : str)
            System.out.print(subStr + " ");
    }

    /**
     * 【程序41】
     *
     * 题目：海滩上有一堆桃子，五只猴子来分。
     * 第一只猴子把这堆桃子平均分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
     * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
     * 第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
     */
    public static void func_41(){
        /*
        题干并未已知。我们假设最后一只猴子拿了1个好了
        6 31 156 781 3906
        1 6  31  156 781
         */
        int count = 1;
        for (int i = 0; i < 5; i++) {
            count = count*5+1;
        }
        System.out.println(count);

    }

    /**
     * 【程序42】
     *
     * 题目：809*??=800*??+9*??+1
     *
     * 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。
     */
    public static void func_42(){
        boolean isPositive = false;
        for (int i = 10; i < 99; i++) {
            if(809*i == 800*i+9*i+1){
                System.out.println(i);
                isPositive = true;
            }
        }
        if(!isPositive){
            System.out.println("不存在一个两位数满足该条件!");
        }
    }


    /**
     * 【程序43】
     *
     * 题目：求0—7所能组成的奇数个数。
     */
    public static void func_43() {
        int n = 8;//位数
        int sum = 0;//总和
        // 1位数情况
        sum += n / 2;
        // 2位数情况
        sum += (n - 1) * n / 2;
        // 3位数情况
        sum += (n - 1) * n * n / 2;
        // 4位数情况
        sum += (n - 1) * n * n * n / 2;
        // 5位数情况
        sum += (n - 1) * n * n * n * n / 2;
        // 6位数情况
        sum += (n - 1) * n * n * n * n * n / 2;
        // 7位数情况
        sum += (n - 1) * n * n * n * n * n * n / 2;
        // 8位数情况
        sum += (n - 1) * n * n * n * n * n * n * n / 2;
        System.out.println("0到7能组成的奇数个数：" + sum);
    }

    /**
     * 【程序44】
     *
     * 题目：一个偶数总能表示为两个素数之和。
     */
    public static void func_44(){

        boolean record = false;
        System.out.println("请输入一个偶素：");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if(i+j == input){
                    //说明input是i和j的和。那么接下来该判断i和j是不是素数了。
                    if(func_44_boolean(i)&&func_44_boolean(j)){
                        record = true;
                        System.out.println(i + " "+j);
                    }
                }
            }
        }
        //System.out.println(record);
    }

    public static boolean func_44_boolean(int value){
        for (int i = 2; i < Math.sqrt(value+1); i++) {
            if(value > 2){
                if(value % i == 0){
                    return false;
                }
            }else if(value == 1){
                return false;
            }else {
                return true;
            }
        }

        return true;

    }


    public static boolean commonTest(){
        /*System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        for (int i = 2; i < value; i++) {
            if(value > 2){
                if(value % i == 0){
                    return false;
                }
            }else if(value == 1){
                return false;
            }else {
                return true;
            }

        }*/
        return true;
    }

    /**
     * 【程序45】
     *
     * 题目：判断一个素数能被几个9整除
     */
    public static void func_45() {
        System.out.println("请输入一个数：");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < input; i++) {
            while (input>8) {
                input /= 9;
                count++;
            }
        }
        System.out.println(count);
    }


    /**
     *
     【程序46】

     题目：两个字符串连接程序
     */
    public static void func_46(){

        String str1 = "lao lee";
        String str2 = "牛刀";
        String str = str1+str2;
        System.out.println(str);
    }

    /**
     *
     【程序47】

     题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。
     */
    public static void func_47(){

        Random random = new Random();
        //这样生成的是[0,50)
        //int count = random.nextInt(50);
        //这样生成的是[1,51)也就是[1,50]
        int count = random.nextInt(50)+1;
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
    }

    /**
     * 【程序48】
     *
     * 题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：
     * 每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。
     */
    public static void func_48(){
        System.out.println("请输入一个4位数：");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int firstNum = Integer.parseInt(String.valueOf(value).substring(0, 1));
        int secondNum = Integer.parseInt(String.valueOf(value).substring(1, 2));
        int thirdNum = Integer.parseInt(String.valueOf(value).substring(2, 3));
        int fourthNum = Integer.parseInt(String.valueOf(value).substring(3, 4));
        System.out.println(firstNum + " " + secondNum +" "+ thirdNum+" "+fourthNum);
        //每位数都加上5
        firstNum +=5;
        secondNum+=5;
        thirdNum+=5;
        fourthNum+=5;
        //用和除以10的余数代替该数字
        firstNum = firstNum%10;
        secondNum = secondNum%10;
        thirdNum = thirdNum%10;
        fourthNum = fourthNum%10;
        //再将第一位和第四位交换，第二位和第三位交换
        int temp = 0;
        temp = firstNum;
        firstNum = fourthNum;
        fourthNum = temp;
        temp = secondNum;
        secondNum = thirdNum;
        thirdNum = temp;
        System.out.println(firstNum + " " + secondNum +" "+ thirdNum+" "+fourthNum);
    }


    /**
     * 题目：计算字符串中子串出现的次数
     */
    public static void func_49(){
        /*
        包含1个字符的子串共n个
        包含2个字符的子串共n-1个
        包含3个字符的子串共n-2个
        包含4个字符的子串共n-3个
        。。。。。
        包含n个字符的子串共1个
        空串1个
        综上所述：子串个数共：1+2+3+。。。+n+1（空串）=n(n+1)/2+1
         */
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = str.length();
        System.out.println("子串出现的次数一共为：" + length*(length+1)/2+1);
    }


    /**
     * 【程序50】
     *
     * 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
     * 计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。
     */
    public static void func_50()  {

        try {
            class Student {
                private long id;
                private String name;
                private BigDecimal chinese;
                private BigDecimal english;
                private BigDecimal mathematics;
                private BigDecimal avg;
                public BigDecimal getChinese() {
                    return chinese;
                }
                public void setChinese(BigDecimal chinese) {
                    this.chinese = chinese;
                }
                public BigDecimal getEnglish() {
                    return english;
                }
                public void setEnglish(BigDecimal english) {
                    this.english = english;
                }
                public BigDecimal getMathematics() {
                    return mathematics;
                }
                public void setMathematics(BigDecimal mathematics) {
                    this.mathematics = mathematics;
                }
                public void setId(long id) {
                    this.id = id;
                }
                public long getId() {
                    return id;
                }
                public String getName() {
                    return name;
                }
                public void setName(String name) {
                    this.name = name;
                }
            }

            Map<String, Student> map = new HashMap<String, Student>();

            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 1; i++) {
                System.out.println("请输入第一个学生的学生号、姓名、语文成绩、数学成绩和英语成绩。分别用空格隔开：");
                Student student = new Student();
                String[] info = scanner.nextLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    student.id = Long.parseLong(info[0]);
                    student.name = info[1];
                    student.chinese = BigDecimal.valueOf(Double.parseDouble(info[2]));
                    student.mathematics = BigDecimal.valueOf(Double.parseDouble(info[3]));
                    student.english = BigDecimal.valueOf(Double.parseDouble(info[4]));
                    student.avg = BigDecimal.valueOf((Integer.parseInt(info[2])+Integer.parseInt(info[3])+Integer.parseInt(info[4]))/3);
                }
                map.put(info[0], student);
            }

            FileWriter fileWriter = new FileWriter("C:\\Users\\niu\\Desktop\\neo.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Code"+" "+"Name"+" "+"Chinese"+" "+"Mathematics"+" "+"English"+" "+"Average");

            for(Map.Entry<String, Student> student:map.entrySet()){
                /*System.out.println(student.getValue().id);
                System.out.println(student.getValue().name);
                System.out.println(student.getValue().chinese);
                System.out.println(student.getValue().getMathematics());
                System.out.println(student.getValue().getEnglish());
                System.out.println(student.getValue().avg);*/
                bufferedWriter.newLine();
                bufferedWriter.write(student.getValue().id + " "+student.getValue().name + " "+student.getValue().chinese + " "+student.getValue().mathematics + " "+student.getValue().english+ " "+student.getValue().avg);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static void func_random(){
        Random random = new Random();
        //System.out.println(random.nextInt());
        System.out.println(random.nextInt(2));
    }


    public static void common(){
        //System.out.println(func_22(05));
        //System.out.println("第五个人的岁数："+func_23_2(5,2));

    }

    public static void main(String[] args) {
        //func_01();
        //func_02();
        //func_03();
        //func_04();
        //func_05();
        //func_06();
        //func_07();
        //func_08();
        //func_09();
        //func_10();
        //func_11();
        //func_12();
        //func_13();
        //func_14();
        //func_15();
        //func_16();
        //func_17();
        //func_18();
        //func_19();
        //func_20();
        //func_21();
        //func_22(5);
        //common();
        //func_27();
        //func_28();
        //func_28_2();
        //func_30();
        //func_31();
        //func_32();
        //func_33();
        //func_34();
        //func_35();
        //func_36();
        //func_37();
        //func_40();
        //func_41();
        //func_42();
        //func_43();
        //System.out.println(commonTest());;
        //func_44();
        //func_45();
        //func_random();
        //func_47();
        //func_48();
        //func_49();
        func_50();
    }
}
