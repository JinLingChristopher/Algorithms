import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

/**
 * Author:     Christopher
 * Written:    2017/5/20
 */

public class PointSET {

    private SET<Point2D> set;

    public PointSET() {
        set = new SET<>();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public int size() {
        return set.size();
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for insert is null");
        }
        set.add(p);
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for contains is null");
        }
        return set.contains(p);
    }

    public void draw() {
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException("Argument rect for range is null");
        }
        return null;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for nearest is null");
        }
        double distance = Double.POSITIVE_INFINITY;
        Point2D res = null;
        for (Point2D other: set) {
            double currentDis = p.distanceSquaredTo(other);
            if (currentDis < distance) {
                distance = currentDis;
                res = other;
            }
        }
        return res;
    }

}
