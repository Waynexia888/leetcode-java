Lintcode 1630 · Interesting String

public class Solution {
    /**
     * @param s: the string s
     * @return: check if the string is interesting
     */
    private String res = "no";
    public String check(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "yes";
        }
        dfs(0, s);
        return res;
    }

    private void dfs(int start, String s) {
        if (start == s.length()) {
            res = "yes";
            return;
        }

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return;
            }
            int len = Integer.parseInt(s.substring(start, i + 1)); // 1
            int nextStart = i + len + 1; // 2
            if (nextStart <= s.length()) {
                dfs(nextStart, s);
            }
        }
    }
}

// "124gray6hunter"
//    s

// nextStart = 1 + 0 + 1 = 2
// nextStart = 4 + 2 + 1 = 7
// nextStart = 6 + 7 + 1 = 14

// "31ba2a"
//      s
// nextStart = 3 + 0 + 1 = 4
// nextStart = 4 + 2 + 1 = 7

枚举字符串n的长度， 然后看一下后面截取出长度为n的子串之后的一位是否是数字
如果是， 则进行下一层DFS继续枚举；
如果能一路枚举到s末尾，则说明可以

/////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param s: the string s
     * @return: check if the string is interesting
     */
    
    public String check(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "yes";
        }
        return dfs(0, s) ? "yes" : "no";  
    }

    private boolean dfs(int start, String s) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            int len = Integer.parseInt(s.substring(start, i + 1)); // 1
            int nextStart = i + len + 1; // 2
            if (nextStart <= s.length()) {
                if (dfs(nextStart, s)) {
                    return true;
                }
            }
        }
        return false;
    }
}