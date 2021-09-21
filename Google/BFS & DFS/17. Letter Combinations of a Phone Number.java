Leetcode 17. Letter Combinations of a Phone Number

class Solution {
    private String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        
        String temp = new String();
        dfs(digits, 0, temp, results);
        return results;
    }
    
    private void dfs(String digits, int index, String temp, List<String> results) {
        if (index == digits.length()) {
            results.add(new String(temp));
            return;
        }
        
        int pos = digits.charAt(index) - '0';
        String s = mapping[pos];
        
        for (int i = 0; i < s.length(); i++) {
            temp += s.charAt(i);
            dfs(digits, index + 1, temp, results);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}

// time: N * 4^N, where N is the length of the digits
// space: O(N), where N is the length of the digits, recursion call stack