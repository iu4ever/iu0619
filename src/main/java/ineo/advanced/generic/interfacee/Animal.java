package ineo.advanced.generic.interfacee;

public interface Animal {
    //接口中不允许存在变量。所以这么写是错误的。但可以给他赋值让他成为常量.
    //Modifier 'public' is redundant for interface fields
    //首先，常量定义的时候我们要大写。其次。上面这个警告。说明，public这种字符完全是多余的。
    //接口中的常量默认为 public static final
    //正确的写法是String NAME = null;
    public String name = null;
    //我来试一下这样定义
    int NUMBER_A = 1;

    public void play();

    public void eat();
}
