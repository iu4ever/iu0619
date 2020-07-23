package ineo.advanced.generic;

import java.util.ArrayList;

public class Generic_4 {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add("neo");
        arr.add(1);//此处体现自动装箱

        for (int i = 0; i < arr.size(); i++) {
            String letter = (String) arr.get(i);
            System.out.println(letter);
        }
    }
}
