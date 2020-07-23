package ineo.other;

public class SubClass_1 extends SuperClass{
    /*private int n;

    public SubClass(){ // 自动调用父类的无参数构造器
        System.out.println("SubClass");
    }

    public SubClass(int n){
        //super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }*/

    /**
     * public SubClass() {
     * }
     *
     * public SubClass(int n) {
     *     super(n);
     * }
     * 父类里面有两个构造函数，一个是无参的构造器，另一个是有参的构造器。
     * 当我继承了父类以后，快捷insert了两个构造函数。就是上面的。一个位有参，另个一位无参。
     */
    private int args;
    public SubClass_1() {
        super(200);
        System.out.println("子类无参构造器输出");
    }

    public SubClass_1(int n) {
        //super();
        System.out.println("子类有参构造器输出");
        /*
        有参构造器的作用不就可以来给子类定义的实例变量进行初始化赋值嘛。阔以。
         */
        this.args = n;
    }
}
