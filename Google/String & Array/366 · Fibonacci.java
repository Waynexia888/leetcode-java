Lintcode 366 · Fibonacci

public class Solution {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // 纯递归，时间复杂度O(n), 空间复杂度O(n),会stack overflow
        // if (n == 1) return 0;
        // if (n == 2) return 1;
        
        // return fibonacci(n - 1) + fibonacci(n - 2);
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {   // n = 5, return 3, loop 4次
            int c = a + b;    // 1, 2, 3, 5
            a = b;            // 1, 1, 2, 3
            b = c;            // 1, 2, 3, 5
        }
        return a;
    }
}