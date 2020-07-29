package ineo.advanced.collection.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetOfInteger {
    public static void main(String[] args) {
        Random rand=new Random(47);//25214903874
        Set<Integer> intset=new HashSet<>();//创建一个HashSet
        for (int i = 0; i <100 ; i++) {
            int ran = rand.nextInt(30);
            intset.add(ran);
        }
        System.out.println(intset);//set特性只能输入相同的数,别看输入了100个数,但是实际上只有30个进去了.
    }
}
