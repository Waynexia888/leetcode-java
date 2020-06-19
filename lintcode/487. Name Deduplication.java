public class Solution {
    /**
     * @param names: a string array
     * @return: a string array
     */
    public List<String> nameDeduplication(String[] names) {
        // write your code here
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String name : names) {
            String str = name.toLowerCase();
            if (!map.containsKey(str)) {
                map.put(str, 1);
                result.add(str);
            }
        }

        return result;
    }
}