public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // 组合型搜索DFS
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        
        dfs(s, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(String s, int index, List<String> temp, List<List<String>> results) {
        // 递归的出口
        if (index == s.length()) {
            results.add(new ArrayList<String>(temp));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (isPalindrome(subStr)) {
                temp.add(subStr);
                dfs(s, i + 1, temp, results);
                temp.remove(temp.size() - 1);        // backtracking
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
}