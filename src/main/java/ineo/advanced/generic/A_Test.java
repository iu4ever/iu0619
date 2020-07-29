package ineo.advanced.generic;

public class A_Test {
    public static void main(String[] args) {
        A_2 a_2 = new A_2();
        a_2.print();

        A_4 a_4 = new A_4();
        A_3 a_3 = new A_3();
        a_4.testUpperBound(a_3);
        a_4.testUpperBound(a_2);

    }



}
