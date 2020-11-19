class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

// 取第一个单词，第一个字母，
// 然后跟后面的所有单词第一个字母进行比较，如果相等，就继续，如果不相等，就return当前的substring（0， i）
// for 循环结束后，如果还没return 说明第一个单词的所有字母都是commom prefix，那就return第一个单词
// time: O(n^2); space: O(1)