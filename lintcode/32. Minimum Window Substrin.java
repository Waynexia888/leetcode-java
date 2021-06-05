public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // 滑动窗口型双指针类型题
        // 时间复杂度:O(256n + m); space O(256m + 256n)
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];

        // 统计target 字符， 时间复杂度: O(m)
        for (char ch : target.toCharArray()) {
            targetHash[ch]++;
        }

        // 同向双指针时间复杂度O(256n);
        int j = 0;
        for (int i = 0; i < source.length(); i++) {
            while (j < source.length() && !vaild(sourceHash, targetHash)) {
                sourceHash[source.charAt(j)]++;
                j++;
            }
            if (vaild(sourceHash, targetHash)) {
                if (j - i < ans) {
                    ans = Math.min(ans, j - i);
                    minStr = source.substring(i, j);
                }
            }
            sourceHash[source.charAt(i)]--;
        }
        return minStr;
    }

    private boolean vaild(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < 256; i++) {
            if (targetHash[i] > sourceHash[i]) {
                return false;
            }
        }
        return true;
    }
} 

///////////////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // time: O(256n + m) = O(n + m), n, m为两串长度; space: O(n + m)
        Map<Character, Integer> sourceMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        String subStr = "";
        int matchedChars = 0; // 存放匹配得上(每个字符出现的次数一样，才算匹配得上)的字符数量

        int j = 0;
        for (int i = 0; i < source.length(); i++) {
            while (j < source.length() && matchedChars < targetMap.size()) {
                char c = source.charAt(j);
                sourceMap.put(c, sourceMap.getOrDefault(c, 0) + 1);
                // java的hashmap中存放的是Integer对象，应使用equals比较值
                if (sourceMap.get(c).equals(targetMap.getOrDefault(c, 0))) {
                    matchedChars++;
                }
                j++;
            }

            if (matchedChars == targetMap.size()) {
                if (j - i < minLength) {
                    minLength = Math.min(minLength, j - i);
                    subStr = source.substring(i, j);
                }
            }

            char cc = source.charAt(i);
            sourceMap.put(cc, sourceMap.get(cc) - 1);
            if (sourceMap.get(cc).equals(targetMap.getOrDefault(cc, 0) - 1)) {
                matchedChars--;
            }
        }
        return subStr;
    }
}