package ineo.advanced.generic.interfacee.impl;

import ineo.advanced.generic.interfacee.Generator;

import java.util.Random;

public class FruitGenerator_3 implements Generator<String> {

    String[] arr = {"apple","banana","pear"};

    public String t() {
        Random random = new Random();
        int i = random.nextInt();
        return arr[i];
    }
}
