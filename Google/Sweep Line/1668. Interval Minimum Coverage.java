Lintcode 1668. Interval Minimum Coverage

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

public class Solution {
    /**
     * @param a: the array a
     * @return: return the minimal points number
     */
    public int getAns(List<Interval> a) {
        // write your code here
        if (a == null || a.size() == 0) {
            return 0;
        }

        Collections.sort(a, (x, y) -> (x.start - y.start));

        int minNumber = 1;
        Interval minInterval = a.get(0);

        for (int i = 1; i < a.size(); i++) {
            Interval cur = a.get(i);
            if (minInterval.end >= cur.start) {
                minInterval.start = Math.max(minInterval.start, cur.start);
                minInterval.end = Math.min(minInterval.end, cur.end);
            } else { // minInterval.end < cur.start
                minNumber++;
                minInterval = cur;
            }
        }
        return minNumber;
    }
}