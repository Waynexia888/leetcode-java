// Given two integers n and k, return all possible combinations of k numbers 
// out of 1 ... n.

// You may return the answer in any order.

 

// Example 1:

// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
// Example 2:

// Input: n = 1, k = 1
// Output: [[1]]



class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(n, k, results, new ArrayList<>(), 1); // index from 1 to n;
        return results;
    }
    
    private void dfs(int n, int k, List<List<Integer>> results, List<Integer> temp, int index) {
        if (temp.size() == k) {
            results.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = index; i <= n; i++) {
            temp.add(i);
            dfs(n, k, results, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

// 本题思想： 回溯法-组合问题
// 做法同子集的做法一样，使用index
// 时间复杂度: O(c(n, k) * k)
// 空间复杂度: O(c(n, k))


///////////////////////////////////////////////////////////////////////////

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(n, k, results, new ArrayList<>(), 1); // index from 1 to n;
        return results;
    }
    
    private void dfs(int n, int k, List<List<Integer>> results, List<Integer> temp, int index) {
        if (k == 0) {
            results.add(new ArrayList<>(temp));
        }
        
        for (int i = index; i <= n; i++) {
            temp.add(i);
            dfs(n, k - 1, results, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}