package ineo.advanced.compare.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparable_Test {

    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People("Sayo", 17, 2));
        list.add(new People("Hina", 17, 1));
        list.add(new People("Tsugu", 16, 3));
        list.add(new People("Dio", 100, 4));
        list.add(new People("Naruto", 15, 7));
        list.add(new People("Donald.Trashump", 15, 6));
        list.add(new People("Sasuke", 15, 6));

        Collections.sort(list);
        for (People p : list) {
            System.out.println(p.toString());;
        }
    }
}
