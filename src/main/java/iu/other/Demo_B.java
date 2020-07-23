package iu.other;

import ineo.other.Demo_A;

public class Demo_B extends Demo_A {
    @Override
    protected void count() {
        super.count();
    }

    public void chenqingling() {
        System.out.println("陈情令"+this.getName());
    }

    public static void main(String[] args) {
        Demo_A a = new Demo_A();
        //不能访问A里面的实例化protected方法。
        //a.sum();
    }
}
