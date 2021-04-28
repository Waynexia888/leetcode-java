public class Solution {
    /**
     * @param A: a list of integer
     * @param K: a integer
     * @param L: a integer
     * @return: return the maximum number of apples that they can collect.
     */
    public int PickApples(int[] A, int K, int L) {
        // time:  ; space: 
        // 前缀和
        int[] prefixSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        // 后缀和
        int[] suffixSum = new int[A.length + 1];
        for (int i = A.length; i > 0; i--) {
            suffixSum[i - 1] = suffixSum[i] + A[i - 1];
        }

        int res = -1;
        // 左边找一个长度为L的区间和 + 右边找一个长度为k的区间和
        res = Math.max(res, getMaxApple(A, L, K, prefixSum, suffixSum));
        // 左边找一个长度为K的区间和 + 右边找一个长度为L的区间和
        res = Math.max(res, getMaxApple(A, K, L, prefixSum, suffixSum));
        return res;
    }

    // 左边找一个长度为l的区间和 + 右边找一个长度为r的区间和
    private int getMaxApple(int[] A, int l, int r, int[] prefixSum, int[] suffixSum) {
        int res = -1;
        int maxL = 0;
        // i不断模拟左区间的右端点位置, maxL存的是右区间左边的可选长为l的区间的最大和
        for (int i = l - 1; i <= A.length - r - 1; i++) {
            maxL = Math.max(maxL, prefixSum[i + 1] - prefixSum[i + 1 - l]);
            res = Math.max(res, maxL + suffixSum[i + 1] - suffixSum[i + 1 + r]);
        }
        return res;
    }
}

// 6, 1, 4, 6, 3, 2, 7, 4
//    i        i

// k = 3, L = 2
// 先考虑左L右K，那么左区间的右端点的范围就是[L - 1, n - k - 1],
// 不断用i来模拟左区间的右端点，找到一个maxL
// 不断模拟在A[n - k, n - 1]区间里找到可选长为k的区间和



// A =            [6, 1,  4,  6,  3,  2,  7,  4]
// prefixSum = [0, 6, 7, 11, 17, 20, 22, 29, 33]

// A =            [ 6,  1,  4,  6,  3,  2,  7, 4]
// suffixSum =    [33, 27, 26, 22, 16, 13, 11, 4, 0]
