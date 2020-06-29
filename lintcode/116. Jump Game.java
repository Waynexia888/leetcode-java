public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // 1. 确定状态： - 最后一步： 青蛙可以跳到石头i； 最后一步不超过跳跃的最大距离： n - 1 - i <= a[i]
        // - 子问题： 青蛙能不能跳到石头i（i < n - 1)
        // - 状态：f[j] 表示青蛙能不能跳到石头j
        // 2. 转移方程：
        // 3. 初始条件： f[0] = True, 因为青蛙一开始就在石头0
        // 4. 计算顺序：
        int n = A.length;
        boolean[] f = new boolean[n];

        // initialization
        f[0] = true;

        for (int j = 1; j < n; j++) {
            f[j] = false;

            // previous stone i before j
            // last jump from i to j
            for (int i = 0; i < j; i++) {
                if (f[i] && i + A[i] >= j) {
                    f[j] = true;
                    break;
                }
            }
        }
        return f[n - 1];

    }
}