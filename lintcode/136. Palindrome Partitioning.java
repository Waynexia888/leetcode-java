public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // 组合型搜索DFS， 巧妙使用startIndex来控制dfs过程
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

//////////////////////////////////////////////////////
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // DFS，使用切割字符串可能出现的位置，来进行dfs
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        
        dfs(s, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(String s, List<String> temp, List<List<String>> results) {
        // 递归的出口
        if (s.length() == 0) {
            results.add(new ArrayList<>(temp));   // deep copy
            return;
        }
        
        // 对于aab这个字符串，它的切分位置为：a|a|b| （'|'代表切分位置,即下标1 到length + 1这段区间）
        for (int i = 1; i < s.length() + 1; i++) {
            if (isPalindrome(s.substring(0, i))) {
                temp.add(s.substring(0, i));
                dfs(s.substring(i, s.length()), temp, results);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String string) {
        if (string == null || string.length() == 0) {
            return true;
        }
        
        int left = 0, right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}