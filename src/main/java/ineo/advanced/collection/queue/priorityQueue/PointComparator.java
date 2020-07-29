package ineo.advanced.collection.queue.priorityQueue;

public class PointComparator {
    private Point pointOne;
    private Point pointTwo;
    public double distance;

    public PointComparator(Point pointOne, Point pointTwo) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        computeDistance();
    }

    //计算两点之间距离
    private void computeDistance() {
        double val = Math.pow((this.pointOne.x - this.pointTwo.x), 2) +
                Math.pow((this.pointOne.y - this.pointTwo.y), 2);
        this.distance = Math.sqrt(val);
    }
}
