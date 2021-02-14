public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    private Map<Integer, Integer> map = new HashMap<>();
    
    public void add(int number) {
        // write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // find value - number in map or not
        // 题目只给你value， 并没有说明number是啥
        for (Integer key : map.keySet()) {
            if (map.containsKey(key) && value - key != key && map.containsKey(value - key)) {
                return true;
            }
            // 有一种可能， 这个key有2个或者2个以上
            if (key * 2 == value && map.get(key) > 1 ) {
                return true;
            }
        }
        return false;
    }
}

////////////////////////////////////
public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
     
    public Map<Integer, Integer> map = new HashMap<>();
    public void add(int number) {
        // write your code here
        int count = map.getOrDefault(number, 0);
        map.put(number, count + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    // two sum, num1 + num2 ??? value
    public boolean find(int value) {
        // write your code here
        for (Integer num : map.keySet()) {
            int num1 = value - num;
            if (num1 == num && map.get(num) >= 2) {
                return true;
            }
            if (num1 != num && map.containsKey(num1)) {
                return true;
            }
        }
        return false;
    }
}