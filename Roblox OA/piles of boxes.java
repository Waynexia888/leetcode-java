// 给一堆高度不同的箱子堆 每一step可以把最高的那堆减到第二高的高度 问要多少steps可以让所有箱子堆一样高度

// Example 1:

// Input: piles = [5, 2, 1]
// Output: 3
// Explanation:
// Step 1: reducing 5 -> 2 [2, 2, 1]
// Step 2: reducing 2 -> 1 [2, 1, 1]
// Step 3: reducing 2 -> 1 [1, 1, 1]
// So final number of steps required is 3.


// Example 2:

// Input: piles = [5, 5, 2, 1]
// Output: 5



// time: O(nlogn);
// space: O(1);

// For piles = [5, 2, 1], 5 needs 2 steps to come to 1(5 -> 2 -> 1) and 2 needs 1 
// step to 1(2 -> 1) and 1 for 0 step. We just need to sort the array and 
// record how many different numbers appeared before and sum them up.

public int minSteps(int[] piles) {
    int len = piles.length;
    if (len <= 1) {
        return 0;
    }

    Arrays.sort(piles);
    int result = 0, distinctNums = 0;
    for (int i = 1; i < len; i++) {
        if (piles[i] == piles[i - 1]) {
            result += distinctNums;
        } else {
            distinctNums++;
            res += distinctNums;
        }
    }

    return result;
}


// time: O(nlogn);
// space: O(n);
// use hashmap, 
// [5,5,2,1] -> 计数{5:2, 2:1, 1:1} -> 排序[1,2,5] -> 求和 0 * 1 + 1 * 1 + 2 * 2 = 5steps

public int minSteps(int[] piles) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < piles.length; i++) {
        map.put(piles[i], map.getOrDefault(piles[i], 0) + 1);
    }

    int result = 0;
    int index = 0;
    for (int key : Arrays.sort(map.keySet())) {
        result += index * map.get(key);
        index++;
    }
    return result;
}