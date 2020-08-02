public class Solution {
    /*
     * @param s: A string
     * 
     * @param dict: A dictionary of words dict
     * 
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // 这个解法在 LeetCode 上面是可以过的，但是 LintCode 这边数据集有点大过不去。
        if (dict == null) {
            return false;
        }

        if (s == null || s.length() == 0) {
            return true;
        }

        return dfs(s, dict);
    }

    private boolean dfs(String s, Set<String> dict) {
        if (s.length() == 0) {
            return true;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            if (dict.contains(s.substring(0, i))) {
                if (dfs(s.substring(i, s.length()), dict)) {
                    return true;
                }
            }
        }
        return false;
    }
}