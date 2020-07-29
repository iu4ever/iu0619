package ineo.advanced.collection.queue.priorityQueue;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue_Test {
    public static void main(String args[]) {

        Comparator<PointComparator> OrderDistance = new Comparator<PointComparator>() {
            public int compare(PointComparator one, PointComparator two) {
                if (one.distance < two.distance)
                    return 1;
                else if (one.distance > two.distance)
                    return -1;
                else
                    return 0;
            }
        };
        /*Comparator<PointComparator> comparator = new Comparator<PointComparator>() {
            @Override
            public int compare(PointComparator o1, PointComparator o2) {
                return 0;
            }
        }*/
        //定义一个优先队列,用来排序任意两点之间的距离，从大到小排
        Queue<PointComparator> FsQueue = new PriorityQueue<PointComparator>(10, OrderDistance);
        for (int i = 0; i < 6; i++) {
            java.util.Random r = new java.util.Random(10);
            Point one = new Point(i * 2 + 1, i * 3 + 2);
            Point two = new Point(i * 5 + 2, i * 6 + 3);
            PointComparator nodecomp = new PointComparator(one, two);
            DecimalFormat df = new DecimalFormat("#.##");
            FsQueue.add(nodecomp);
        }
        DecimalFormat df = new DecimalFormat("#.###");
        for (int i = 0; i < 6; i++) {
            System.out.println(df.format(FsQueue.poll().distance));
        }
    }
}
