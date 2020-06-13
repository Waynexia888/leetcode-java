public class Solution {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // brute force solution, time complexity: O(n^2),
        // s.substring() will create a new string to compare with the target, space
        // complexity: O(n)
        // 注意：java中string比较大小只能用equals(), 不能用"=="
        // follow up, 能不能不用substring？
        if (target == null || target.equals("")) {
            return 0;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            if (source.substring(i, i + target.length()).equals(target)) {
                return i;
            }
        }

        return -1;

    }
}