public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        boolean[] isUsed = new boolean[arr.length];
        List<String> result = new ArrayList<>();
        String temp = new String();
        stringPermutation2Helper(result, temp, arr, isUsed);
        return result;
    }

    public void stringPermutation2Helper(List<String> result, String temp, char[] arr, boolean[] isUsed) {
        if (temp.length() == arr.length) {
            result.add(temp);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 如果已经用过了该字符，跳过即可
            if (isUsed[i] == true) {
                continue;
            }

            // 去重步骤
            // 不能跳过一个a选下一个a
            if (i != 0 && arr[i] == arr[i - 1] && isUsed[i - 1] == false) {
                continue;
            }

            // make change
            isUsed[i] = true;
            temp += arr[i];

            // 找到所有 temp 开头的排列
            stringPermutation2Helper(result, temp, arr, isUsed);

            // backtracking
            temp = temp.substring(0, temp.length() - 1);
            isUsed[i] = false;

        }
    }
}

///////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (str == null) {
            return results;
        }

        // string is immuatble
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        String temp = new String();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, temp, results, visited);
        return results;
    }

    private void dfs(char[] arr, String temp, List<String> results, boolean[] visited) {
        if (temp.length() == arr.length) {
            results.add(new String(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                continue;
            }

            temp += arr[i];
            visited[i] = true;
            dfs(arr, temp, results, visited);
            temp = temp.substring(0, temp.length() - 1);
            visited[i] = false;
        }
    }
}
