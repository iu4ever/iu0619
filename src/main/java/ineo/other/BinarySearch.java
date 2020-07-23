package ineo.other;

public class BinarySearch {

    public static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;
        while (array[mid] != target && right > left) {
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
            //判断在缩小范围后，新的left或者right是否会将target排除
            if (array[right] < target) {
                break;//若缩小后right比target小，即target不在数组中
            } else if (array[left] > target) {
                break;//若缩小后left比target大，即target不在数组中
            }
        }
        return (array[mid] == target);
    }

    public static void neo() {
        double a = 0.1;
        double b = 0.01;
        double c = 0.001;
        double d = 0.0001;
        double e = 0.00001;
        double f = 0.000001;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }

    public static void switch_neo(String str) {
        if (null == str) {
            System.out.println("参数为空！");
            return;
        }
        switch (str) {
            case "neo":
                System.out.println("it's niu.");
                break;
            case "diyaqin":
                System.out.println("it's diyaqin.");
                break;
            default:
                System.out.println("who am I?");
        }
    }


    public static void main(String[] args) {
        int[] array = {1,2,4,5,7,9};
        int neo = 6;
        //binarySearch(array,neo);
        switch_neo("diyaqin");

    }
}
