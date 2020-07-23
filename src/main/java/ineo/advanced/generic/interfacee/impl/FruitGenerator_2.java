package ineo.advanced.generic.interfacee.impl;

import ineo.advanced.generic.interfacee.Generator;

/*
如果我们在实现的接口中写了<T>。而前面的实现类不写。会有什么结果呢。
报错
Cannot resolve symbol 'T' 不认识这个‘T’
对的不认识就对了。因为我们的T本来就是泛型。本来就需要让实现类去定义。如果实现类不定义。那么实例化的时候也得定义。所以，他报错是对的。
 */
public class FruitGenerator_2<T> implements Generator<T> {

    public T t() {
        return null;
    }
}
