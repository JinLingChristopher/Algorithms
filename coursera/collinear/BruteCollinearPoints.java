import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:     Christopher
 * Written:    2017/4/23
 * This program solve the problem: Given a set of n distinct points in the plane,
 * find every (maximal) line segment that connects a subset of 4 points.
 */

public class BruteCollinearPoints {

    private LineSegment[] segments;

    /**
     * find all line segments containing 4 points
     */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException("Point is null");
        }
        for (int idx = 0; idx < points.length; idx++) {
            if (points[idx] == null) {
                throw new NullPointerException("Point in " + idx + " position is null");
            }
            for (int j = idx + 1; j < points.length; j++) {
                if (points[idx].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicate points in the given points set.");
                }
            }
        }

        Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy);
        ArrayList<LineSegment> lines = new ArrayList<>();

        for (int p = 0; p < copy.length - 3; p++) {
            for (int q = p + 1; q < copy.length - 2; q++) {
                for (int r = q + 1; r < copy.length - 1; r++) {
                    for (int s = r + 1; s < copy.length; s++) {
                        Comparator<Point> pc = copy[p].slopeOrder();
                        if ((pc.compare(copy[q], copy[r]) == 0) && (pc.compare(copy[q], copy[s]) == 0)) {
                            LineSegment line = new LineSegment(copy[p], copy[s]);
                            lines.add(line);
                        }
                    }
                }
            }
        }
        segments = lines.toArray(new LineSegment[lines.size()]);
    }

    /**
     * the number of line segments
     */
    public int numberOfSegments() {
        return segments.length;
    }

    /**
     * the line segments
     */
    public LineSegment[] segments() {
        return Arrays.copyOf(segments, segments.length);
    }
}

