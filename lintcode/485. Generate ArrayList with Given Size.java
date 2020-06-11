public class Solution {
    /**
     * @param size: An integer
     * @return: An integer list
     */
    public List<Integer> generate(int size) {
        // 时间复杂度O(n), 空间复杂度O(n)
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            result.add(i);
        }
        return result;
    }
}