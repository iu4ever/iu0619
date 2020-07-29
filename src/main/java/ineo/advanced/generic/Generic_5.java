package ineo.advanced.generic;

import java.util.Map;

public class Generic_5<T> {

    public Generic_5() {

    }
    //如果只插入这个构造函数，会覆盖原来的无参构造函数，实例化的时候不能调用无参构造方法。
    //如果还想要调用无参的构造方法。我们需要再把无参的构造方法插入一下。
    public Generic_5(T t) {
        this.t = t;
    }

    private T t;

    public T getT() {
        return t;
    }

    public <Z> Z typeBound_1(Z z) {

        return z;
    }

    public <Z> void typeBound_2() {

    }

    public <Z> void typeBound_3(String str) {

    }

    //方法在声明的时候声明了一个泛型。这个泛型有3个参数，既然定义了。那我们就在方法里面用起来。
    public <X,Y,Z> Y typeBound_4(String str, Map<String,Object> map, Integer integer,X x,Y y,Z z) {


        //上面的返回值类型已经定了是Y。那么我们需要返回一个Y
        return y;
    }

    public <Z extends Number> Z typeBound_5(Z z) {

        return z;
    }



}
