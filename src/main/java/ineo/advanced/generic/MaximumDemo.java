package ineo.advanced.generic;

public class MaximumDemo {

    public static <T extends Comparable<T>> T maximum(T x,T y,T z) {

        //可以哎这种写法。我还是第一次注意到这种写法。
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.printf("%d,%d,%d中最大的一个数为：%d\n\n",3,4,5,maximum(3,4,5));
        //System.out.println("3,4,5中最大的一个数为："+maximum(3,4,5));
        System.out.printf("%.1f,%.1f,%.1f中最大的一个数为：%.1f\n", 5.5, 6.6, 7.7, maximum(5.5, 6.6, 7.7));
        System.out.printf("%s,%s,%s中最大的一个数为：%s\n","niu","niuia","itsniu",maximum("niu","niuian","itsniu"));
    }
}
