Leetcode 392. Is Subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int indexS = 0,  indexT= 0;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                indexT++;
            } else {
                indexT++;
            }
            if (indexS == s.length()) {
                return true;
            }
        }
        return false;
    }
}

    
// "ahbgdc"
//        i
 
    
// "abc"
//     j