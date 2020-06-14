public class Solution {
    /**
     * @param str: the string
     * @return: the number of substrings
     */
    public int stringCount(String str) {
        // 使用同向双指针解决
        // 找到第一个为‘0’的数，以此开始，查看有多少个连续的‘0’， 直到找到非‘0’的数，以此结束
        // 时间复杂度 O(n), 空间复杂度O(1)

        if (str == null) {
            return 0;
        }

        int j = 1, ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                continue;
            }
            j = Math.max(j, i + 1);
            while (j < str.length() && str.charAt(j) == '0') {
                j++;
            }

            ans += j - i;
        }
        return ans;
    }
}