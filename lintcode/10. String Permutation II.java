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