Leetcode 69. Sqrt(x)

class Solution {
    public int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }
        
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int)end;
        }
        return (int)start;    
    }
}