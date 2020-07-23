package ineo.other;

public class SubClass_2 extends SuperClass{
    private int n;

    public SubClass_2(){
        //super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass2");
    }

    public SubClass_2(int n){ // 自动调用父类的无参数构造器
        System.out.println("SubClass2(int n):"+n);
        this.n = n;
    }
}
