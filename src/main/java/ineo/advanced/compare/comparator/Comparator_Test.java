package ineo.advanced.compare.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_Test {

    public static List<People> sortPeople(List<People> list) {
        Collections.sort(list, new Comparator<People>() {
            /*int a = p1.age;    //比较的是age
            int b = p2.age;
            return a<b ? -1 : a==b ? 0 : 1 ;    //当a<b返回-1，a==b返回0，a>b返回1*/

            @Override
            public int compare(People o1, People o2) {
                if (o1.id < o2.id) {
                    return -1;
                } else if (o1.id == o2.id) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }.reversed().reversed().thenComparing(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.age < o2.age ? -1 : o1.age == o2.age ? 0 : 1;
            }
        }.thenComparingInt(x -> x.name.length())));
        return list;
    }

    public static void main(String[] args) {
        People p1 = new People("牛建业", 27, 3);
        People p2 = new People("邸雅琴", 25, 5);
        People p3 = new People("王田芳", 26, 4);
        People p4 = new People("杨伟东", 26, 1);
        People p5 = new People("张文敏", 27, 2);
        List<People> list = new ArrayList<People>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(new People("Sayo", 17, 2));
        list.add(new People("Hina", 17, 1));
        list.add(new People("Tsugu", 16, 3));
        list.add(new People("Dio", 100, 4));
        list.add(new People("Naruto", 15, 7));
        list.add(new People("Donald.Trashump", 15, 6));
        list.add(new People("Sasuke", 15, 6));
        sortPeople(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
