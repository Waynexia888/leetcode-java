public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        // prime number从2 开始;
        // prime number的定义是一个正整数只能被1和本身整除。
        // A prime number is a number which is divisible by only two numbers: 1 and
        // itself. So, if any number is divisible by any other number, it is not a prime
        // number.
        // 时间复杂度：O(n) * O(sqrt(n)), 空间复杂度O(n)

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // n = 12, 12 = 2 * 6; 12 = 3 * 4; 12 = sqrd(12) * sqrd(12); 12 = 4 * 3; 12 = 6
        // * 2;
        // 如果在[2, sqrt(n)]这个区间内没有发现整除因子， 那么在[sqrt(n), n]也一定不会发现整除因子
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // i 的倍数不可能是质数
                // i = 2, 2 * 2; 4 + 2； 6 + 2； 8 + 2；
                // i = 3; 2 * 3; 6 + 3;
                // 2, 3, 4false, 5, 6false, 7, 8false, 9false, 10false, 11
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

}