package ineo.advanced.generic;

public class Generic_3<T> {
    T key;

    //如果我们要插入一个构造方法的话是这样，但我们现在先把他注释掉
    //我们现在给他放开
    public Generic_3(T key) {
        this.key = key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public static void aurora() {
        System.out.println("this is my chosen");
    }

    public void persistence() {
        System.out.println("persistence");
    }
}
