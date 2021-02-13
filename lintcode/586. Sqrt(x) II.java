public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        double start = 0, end = x;
        
        if (x <= 1.0) {
            end = 1.0;
        }
        
        while (start + 1e-12 < end) {
            double mid = start + (end - start) / 2;
            if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }
}
