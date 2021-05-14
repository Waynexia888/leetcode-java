public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder(); // 相当于空空字符串
        // 从后往前遍历数组
        for (int i = arr.length - 1; i >= 0; i--) {
            // eg; arr = ["", "hello", "world", ""]
            if (arr[i].equals("")) {
                continue;
            }
            // 当前字符串不等于""的时候， 且不是模拟器第一个元素的情况下
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}

////////////////////////////////////////////////////
public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }

        s = s.trim();
        String[] arr = s.split("\\s+"); 
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i != 0) {
                sb.append(arr[i]);
                sb.append(" ");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}