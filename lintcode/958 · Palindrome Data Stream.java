public class Solution {
    /**
     * @param s: The data stream
     * @return: Return the judgement stream
     */
    public int[] getStream(String s) {
        // Write your code here
        int[] results = new int[s.length()];
        int oddNumber = 0;
        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
            if (count[c] % 2 == 1) {
                oddNumber++;
            } else {
                oddNumber--;
            }

            if (oddNumber > 1) {
                results[i] = 0;
            } else {
                results[i] = 1;
            }
        }
        return results;
    }
}

// odd = 0
// "abab"   ->  ['a': 2, 'b': 2]
// [1, 0, 1, 1]

// abab -> abba
