public class Solution {
    /**
     * @param nums: a integer array
     * @return: return an integer denoting the number of non-unique(duplicate) values
     */
    public List<Integer> countduplicates(List<Integer> nums) {
        // time: O(n); space: O(n)
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            if (!set.contains(n)) {
                set.add(n);
                continue;
            }
            if (!resultSet.contains(n)) {
                result.add(n);
                resultSet.add(n);
            }
        }
        return result;
    }
}

// result = {2, 1}
// resultSet = (2, 1)

/////////////////////////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: a integer array
     * @return: return an integer denoting the number of non-unique(duplicate) values
     */
    public List<Integer> countduplicates(List<Integer> nums) {
        // time: O(n); space: O(n)
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) == 2) {
                result.add(n);
            }
        }
        return result;
    }
}