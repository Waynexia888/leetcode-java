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


/////////////////

public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // corner case， 如果target是空， 返回下标0;
        if (target == null || target.length() == 0) {
            return 0;
        }
        // corner case: 如果target长度 大于 source的长度
        if (target.length() > source.length()) {
            return -1;
        }
        
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                //内层循环时，j可以++； 但是i不能++；因此第一个字母相同时，可以通过比较i + j 和 j比较下一个字母是否相同
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}