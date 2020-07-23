package ineo.decorator.cake;

public abstract class Decorator extends Cake{
    //先来引用一个Cake
    Cake cake;
    //再来写个构造器来注入Cake
    // 引用一个Cake，让被装饰者进入装饰者之中;
    // 这里用的是构造方法注入,这样就可以调用Cake实例的方法了。
    public Decorator(Cake cake) {
        this.cake = cake;
    }
    public abstract String getRemark();
}

