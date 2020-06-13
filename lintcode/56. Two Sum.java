public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // 哈希表， 时间复杂度O(n), 空间复杂度O(n)
        // follow up ? 能否用双指针算法 返回对应的下标
        // 使用双指针算法，需要先排序， 在双指针， 同时还要考虑排序后，对应的数的下标与原来的数的下标发生了变化
        // 因此需要生成新的数组，来记录原来的数对应的下标
        // 这样时间复杂度O(nlogn), 空间复杂度O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int[] result = { map.get(target - numbers[i]), i };
                return result;
            }
            map.put(numbers[i], i);
        }
        return new int[0]; // 长度为0的， 空数组
    }
}