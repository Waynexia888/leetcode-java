public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // 采用dfs解决此问题，每次向下递归时要么删除一个字符，要么删除两个字符。
        // 本题同136. palindrome parttitioning 属于同一类型题
        // 时间复杂度：O(2^n), n为字符串长度; 除了字符串最后一位，其他位置都有两种切割方式
        // 空间复杂度：O(2^n^2),n为字符串长度; 存储所有情况需要所有切分方式*n 的空间
        List<List<String>> results = new ArrayList<>();
        // if (s == null || s.length() == 0) {
        //     return results;
        // }
        
        dfs(s, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(String s, int index, List<String> temp, List<List<String>> results) {
        // 递归的出口
        if (index == s.length()) {
            results.add(new ArrayList<>(temp));     // deep copy, copy content;
            return;
        }
        // 每次拆分一个字符
        String str = s.substring(index, index + 1);
        temp.add(str);
        dfs(s, index + 1, temp, results);
        temp.remove(temp.size() - 1);         // backtracking
        
        // 拆分两个字符的情况,需要做下标越界处理
        // 因为当index = length - 1的时候， index + 2 > s.length(), 递归没出口了
        if (index <= s.length() - 2) {
            str = s.substring(index, index + 2);
            temp.add(str);
            dfs(s, index + 2, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}