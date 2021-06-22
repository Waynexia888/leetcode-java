// Given a list of words and two words word1 and word2, return the shortest 
// distance between these two words in the list.

// Example:
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Input: word1 = “coding”, word2 = “practice”
// Output: 3
// Input: word1 = "makes", word2 = "coding"
// Output: 1
// Note:
// You may assume that word1 does not equal to word2, 
// and word1 and word2 are both in the list.


class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // time: O(n), space: O(1)
        // use Integer a, b to record the status（使用int类型来记录状态）
        int result = words.length;
        int a = -1, b = -1;  
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            } else if (words[i].equals(word2)) {
                b = i;
            }
            
            if (a != -1 && b != -1) {
                result = Math.min(result, Math.abs(a - b));
            }
        }
        return result;   
    }
}

// 本题的思想是使用int类型来记录状态，达到优化时间复杂度的效果