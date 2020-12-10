class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int result = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        result = Math.min(result, Math.abs(i - j));
                    }
                }
            }
        }
        return result;
    }
}

time: O(n^2); space: O(1)

////////////////////////////////////////

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int result = words.length;
        int a = -1, b = -1; // a, b 用来记录word1， word2的下标位置
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            } else if (words[i].equals(word2)) {
                b = i;
            }
            
            // 讲究的是同时性，当word1和word2 都找到时
            if (a != -1 && b != -1) {
                result = Math.min(result, Math.abs(a - b));
            }
        }
        return result;
    }
}


