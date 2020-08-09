/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // 基于 PriorityQueue, 从远到近排序。当 PQ 里超过 k 个的时候，就 pop 掉一个。 时间复杂度 

        Point[] results = new Point[k];
        if (points == null || points.length == 0 || k <= 0) {
            return results;
        }
        
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (getDistance(a, origin) != getDistance(b, origin)) {
                    return getDistance(b, origin) - getDistance(a, origin);
                }
                if (a.x != b.x) {
                    return b.x - a.x;
                }
                return b.y - a.y;
            }
        });
        
        for (Point point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        for (int i = 0; i < k; i++) {
            results[k - i - 1] = maxHeap.poll();
        }
        return results;
    }
    
    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);  
    }
}