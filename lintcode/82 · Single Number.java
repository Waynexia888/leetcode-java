public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        int result = 0;
        for (int i : A) {
            result = result ^ i;
        }
        return result;
    }
}

// 可以利用异或^的运算性质来解题
// a^a = 0
// a^0 = a
// time: O(n); space: O(1)