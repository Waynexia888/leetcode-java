public class Solution {
    /**
     * @param str: the pattern 
     * @return: the minimum number
     */
    public String formMinimumNumber(String str) {
        // Write your code here.
        if (str == null || str.length() == 0) {
            return ""; 
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() + 1; i++) {
            sb.append(i + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'D') {
                int j = i;
                while (j < str.length() && str.charAt(j) == 'D') {
                    j++;
                }
                swap(sb, i, j);
                i = j;
            }
        }
        return sb.toString();
    }

    private void swap(StringBuilder sb, int i, int j) {
        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
    }
}


// D D I D D I I D
// i 
// j
// 1 2 3 4 5 6 7 8 9

// 3 2 1 6 5 4 7 9 8 

// 碰到一个D的时候，交换一下位置（从当前的D 到当前的D的位置 + 1）
// 碰到多个D的时候，交换一下位置（从第一个D 到最后一个D的位置 + 1）
// 碰到I的时候，直接跳过，不做任何改变
