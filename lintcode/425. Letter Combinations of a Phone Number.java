public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    String[] Keyboard = new String[]{"", "", "abc", "def", "ghi", 
                                    "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }

        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb, results);
        return results;
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> results) {
        // base case
        if (index == digits.length()) {
            results.add(sb.toString());
            return;
        }
        String letters = Keyboard[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            sb.append(c);
            dfs(digits, index + 1, sb, results);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

//////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public String[] keyboard = new String[]{"", "", "abc", "def", "ghi", "jkl", 
                                            "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        String temp = new String();
        dfs(digits, 0, temp, results);
        return results;
    }

    private void dfs(String digits, int startIndex, String temp, List<String> results) {
        if (startIndex == digits.length()) {
            results.add(new String(temp));
            return;
        }

        int digit = digits.charAt(startIndex) - '0';
        String str = keyboard[digit];  // "abc"
        for (int i = 0; i < str.length(); i++) {
            temp += str.charAt(i);
            dfs(digits, startIndex + 1, temp, results);
            temp = temp.substring(0, temp.length() - 1);
        }

    }
}