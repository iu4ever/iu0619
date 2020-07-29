package ineo.advanced.generic;

import ineo.advanced.generic.interfacee.Generator;
import ineo.advanced.generic.interfacee.UserInterface;

public class A_4<Y extends A_1> {
    public Y y;
    public Y getY() {
        return y;
    }
    public void setY(Y y) {
        this.y = y;
    }

    //多继承都是接口才有的行为。Z也可以继承一个类和多个接口。如果我们在实例化A_4并调用该方法的话，我们必须先指定A_1这个类。范例在A_Test中
    public <Z extends A_1 & Generator & UserInterface> Z testUpperBound(Z z) {
        System.out.println(z.toString());
        return z;
    }

    public static void main(String[] args) {
        A_4 a_4 = new A_4();
        A_1 a_1 = new A_1();
        A_2 a_2 = new A_2();
        a_4.setY(a_1);
        a_4.setY(a_2);
        A_1 y = a_4.getY();
        //上界会影响读数据，必须通过强转类型才能正确读取
        //往出取A_1的时候没有可以不用强转。A_2是A_1的子类，得加强转
        A_2 x = (A_2)a_4.getY();
    }
}
