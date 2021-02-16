public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1, right = numbers.length - 1;
            int target = -numbers[i];
            twoSum(numbers, left, right, target, result);
        }
        return result;
    }
    
    private void twoSum(int[] numbers, int left, int right, int target, List<List<Integer>> result) {
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(numbers[left]);
                temp.add(numbers[right]);
                result.add(temp);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}

// [-1, -1, -1, 0, 1]
// [-1, -1, 0]