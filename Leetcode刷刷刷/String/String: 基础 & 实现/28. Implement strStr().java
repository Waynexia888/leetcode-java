class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i < haystack.length(); i++) {
            // eg: haystack: hello, i = 3; needle: abc; 3 + 3 > 5; break;
            if (i + needle.length() > haystack.length()) {
                break;
            }
            // //内层循环时，j可以++； 但是i不能++；因此第一个字母相同时，可以通过比较i + j 和 j比较下一个字母是否相同
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}

// time: O(m * n); space: O(1)