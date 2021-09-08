Lintcode 888 · Valid Word Square

public class Solution {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        // Write your code here
        if (words.length != words[0].length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[0].length(); j++) {
                if (words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}