package ineo.scanner;
import java.util.Scanner;

public class TestScanner {

    public static void main(String[] args) {
        //testNext();
        /*
        输入：       a   bbbbb
        输出：str:a
         */
        testNextLine();
        /*
        输入：       a   bbbbb
        输出：str:       a   bbbbb
         */
    }
    public static void testNext(){
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("str:"+str);
    }
    public static void testNextLine(){
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("str:"+str);
    }
}
