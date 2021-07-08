class Solution {
    public int fib(int n) {
        // time: O(n); space: O(n)
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        // state: dp[i] 以当前位置结尾的斐波那契和
        int[] dp = new int[n + 1];
        
        // initialization:
        dp[0] = 0;
        dp[1] = 1;
        
        // function: dp[i] = dp[i - 1] + dp[i - 2];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        // answer:
        return dp[n];
    }
}

///////////////////////////////////////////////////////////////////////

class Solution {
    public int fib(int n) {
        // time: O(n); space: O(1)
        // 因为只跟前两个数的和有关系，所以用两个变量来代替dp数组，优化空间
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        int first = 0;
        int second = 1;
        
        for (int i = 2; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
