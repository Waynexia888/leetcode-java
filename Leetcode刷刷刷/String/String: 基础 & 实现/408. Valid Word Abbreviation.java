class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            
            if (!Character.isDigit(abbr.charAt(j))) {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            } else {
                if (abbr.charAt(j) == '0') return false;
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += num;
            }
        }            
        return i == word.length() && j == abbr.length();
    }
}

Time: O(m + n) 因为同时遍历word 和 abbr
Space: O(1)

