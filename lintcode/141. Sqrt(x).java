public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // time: O(log(x)); space: O(1)
        long X = (long) x;
        long start = 0, end = X;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid > X) {
                end = mid;
            } else {
                start = mid;
            }
        }
    
        if (end * end <= X) {
            return (int) end;
        }
        return (int) start;
    }
}

