public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // 时间复杂度: O(nlogn); 空间复杂度: O(1)
        char[] sort_A = A.toCharArray();
        Arrays.sort(sort_A);
        char[] sort_B = B.toCharArray();
        Arrays.sort(sort_B);
        return Arrays.equals(sort_A, sort_B);
    }
}

//////////////////////////////////////////////////////
public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // 使用哈希表或者数组
        int[] counter = new int[256];
        for (int i = 0; i < A.length(); i++) {
            counter[(int)A.charAt(i)] += 1;
        }
        
        for (int j = 0; j < B.length(); j++) {
            counter[(int)B.charAt(j)] -= 1;
        }
        
        for (int k = 0; k < counter.length; k++) {
            if (counter[k] != 0) {
                return false;
            }
        }
        return true;
    }
}

/////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
        }
        
        for (int j = 0; j < B.length(); j++) {
            if (!map.containsKey(B.charAt(j))) {
                return false;
            }
            map.put(B.charAt(j), map.get(B.charAt(j)) - 1);
        }
        
        for (Integer count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}