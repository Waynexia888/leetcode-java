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

