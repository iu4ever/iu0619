package ineo.advanced.generic;

import ineo.advanced.generic.interfacee.UserInterface;

/*public class Client<X,Y,T> implements UserInterface<T,B> {
    @Override
    public T testT(T t) {
        return null;
    }

    @Override
    public B testB(B b) {
        return null;
    }
}*/
/*
上面那样写不对，虽然UserInterface已经定义了<T,B>但是Client中没有声明B，所以B会报错未定义。所以需要Client中也要声明<X,Y,T,B>
 */
public class Client<X,Y,T,B> implements UserInterface<T,B> {
    @Override
    public T testT(T t) {
        return null;
    }

    @Override
    public B testB(B b) {
        return null;
    }
}
