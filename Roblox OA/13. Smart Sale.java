// A sale executive needs to simplify an assigned sales task. The task is to sell 
// the items given to her in a bag, where each item has an ID number.

// It is easier to sell items with the same ID numbers. The sales executive also 
// decides to remove some items from the bag. The largest number of items that 
// she can remove is also known to her. Find the minimum number of different 
// number of different IDs the final bag can contain after removing the allowed 
// number of items.

// For examples, she starts with a bag that contains the following n = 6 items:
// ids = [1, 1, 1, 2, 2, 3] and she can remove m = 2 items. If she removes 2 of 
// items 1, she will still have items of all three types. She could remove 2 of 
// item 2, and have ids = [1, 1, 1, 3] with 2 discrete item types or remove 1 
// each of types 2 and 3 leaving ids = [1, 1, 1, 2].
// either way, there are 2 item types left.

// complete  the function deleteProducts. The function must return an integer that
// denotes the minimum number of different IDs the final bag can contain.



// https://www.geeksforgeeks.org/minimum-number-of-distinct-elements-after-removing-m-items/

// https://leetcode.com/discuss/interview-question/853151/Roblox-New-Grad-Online-Assessment-Questions


// 1- Count the occurrence of elements and store in the hash.
// 2- Sort the hash.
// 3- Start removing elements from hash.
// 4- Return the number of values left in the hash.

public int deleteProducts(List<Integer> ids, int m) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    int n = ids.size();
    int size = 0;

    for (int i = 0; i < n; i++) {
        if (!map.containsKey(arr[i])) {
            map.put(ids.get(i), 1);
            size++;
        } else {
            map.put(ids.get(i), map.get(ids.get(i)) + 1);
        }
    }

    map = sortByValue(map);

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() <= m) {
            m -= entry.getValue();
            count++;
        } 
    }
    return size - count;
}

private HashMap<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
    List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    });

    HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();

    for (Map.Entry<Integer, Integer> entry : list) {
        temp.put(entry.getKey(), entry.getValue());
    }
    return temp;
}

// time: O(nlogn);
// space: O(n)