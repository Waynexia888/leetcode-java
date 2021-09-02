Lintcode 391 · Number of Airplanes in the Sky

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Point {
    int time;
    int flag;
    public Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
}
public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }

        List<Point> list = new ArrayList<>();
        for (Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, -1));
        }

        Collections.sort(list, (Point p1, Point p2) -> {
            if (p1.time == p2.time) {
                return p1.flag - p2.flag;
            }
            return p1.time - p2.time;
        });

        int ans = 0, count = 0;
        for (Point p : list) {
            if (p.flag == 1) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}