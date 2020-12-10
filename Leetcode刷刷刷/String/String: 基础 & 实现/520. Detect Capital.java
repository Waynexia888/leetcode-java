class Solution {
    public boolean detectCapitalUse(String word) {
        // 统计有多少个大写的字母
        int numOfCapitals = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                numOfCapitals++;
            }
        }
        
        if (numOfCapitals == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        } else if (numOfCapitals == 0) {
            return true;
        } else if (numOfCapitals == word.length()) {
            return true;
        }
        return false;
    }
}
