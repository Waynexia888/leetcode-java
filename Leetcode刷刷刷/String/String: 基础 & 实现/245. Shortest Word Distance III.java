class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = words.length;
        int a = -1, b = -1;
    
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            } 
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    a = b;
                }
                b = i;
            }
           
            if (a != -1 && b != -1) {
                result = Math.min(result, Math.abs(a - b));
            }
        }
        return result;
    }
}


Time: O(n);
Space; O(1)
