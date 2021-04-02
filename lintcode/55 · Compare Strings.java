public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // time: O(n); space: O(1)

        int[] count = new int[256];

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);  
            count[c]++;
        }

        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            count[c]--;
            // if (count[c] < 0) {
            //     return false;
            // }
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
