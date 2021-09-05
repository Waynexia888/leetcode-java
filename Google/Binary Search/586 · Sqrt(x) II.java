Lintcode 586 · Sqrt(x) II

public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        if (x == 1) {
            return 1.0;
        }

        double start = 0, end = Math.max(x, 1.0);
        double esp = 1e-10;
        while (start + esp < end) {
            double mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}