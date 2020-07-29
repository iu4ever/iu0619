package ineo.advanced.generic;

public class Generic_1 {

    public static <E> void printArray(E[] array) {

        for (E element : array) {
            System.out.printf("%s *_*\t",element);//1	2	3	4
        }
    }

    public static void main(String[] args) {
        //int []array = {1, 2, 3, 4};
        Integer[] arr = {1,2,3,4};
        /*
        printArray(array);出错。
        printArray(arr);可以
        原因是int只是个数据类型而已，他甚至和Object都没有什么关系吧？？
        Integer是包装类。他继承了Number也实现了Comparable。而且往上说也是Object的子类
         */
        Double[] doubleArray = {3.4, 5.6, 4.4};
        Character[] charArray = {'a', 'b', 'c', 'A', 'B', 'C'};
        printArray(arr);
        System.out.println();
        printArray(doubleArray);
        System.out.println();
        printArray(charArray);
    }
}
