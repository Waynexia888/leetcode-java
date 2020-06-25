public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // 时间复杂度: O(nlogn); 空间复杂度: O(1)
        char[] sort_A = A.toCharArray();
        Arrays.sort(sort_A);
        char[] sort_B = B.toCharArray();
        Arrays.sort(sort_B);
        return Arrays.equals(sort_A, sort_B);
    }
}