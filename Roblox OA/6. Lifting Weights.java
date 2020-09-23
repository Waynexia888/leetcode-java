第二题有四个test case 超时，最后也没弄出来
我的思路是回溯求出所有的子集，然后对子集求和，满足条件的上
不知道大家有没有更好的方法

第二题我也是用backtracking做的，case全过了

Ollie is new to the gym and is figuring out the maximum weights she can lift.
The maximum capacity of the barbell is given as maxCapacity. Each barbell plate 
has a weight, given by weights[i]. Now Ollie has to select as many plates as she
can but the total weight of the selected plates should not exceed maxCapacity.
What is the maximum weight of plates Ollie can add to the barbell? For example, 
given barbell plates of weights of 1, 3, and 5 lbs and a barbell of maximum
capacity 7lbs - the right plates to insert would be 1 and 5 lbs (1 + 5 = 6),
thus making the right answer 6.

All the possible combination of items that Ollie can insert are: 
{}, {1}, {3}, {5}, {1, 3}, {1, 5}, {3, 5}, and {1, 3, 5}

complete the weightCapacity function. The function must return an integer denoting
the maximum capacity of items that he can purchase.


public int weightCapacity(int[] weights, int maxCapacity) {
    if (weights == null || weights.length == 0) {
        return 0;
    }

    List<List<Integer>> results = new ArrayList<>();
    dfs(weights, results, new ArrayList<>(), 0);

    int ans = 0;
    for (int i = 0; i < results.size(); i++) {
        int count = 0;
        for (int j = 0; j < results.get(i).size(); j++) {
            count += results.get(i).get(j);
        }
        if (count < maxCapacity) {
            ans = Math.max(ans, count);
        }
    }
    return ans;
}

private void dfs(int[] weights, List<List<Integer>> results, List<Integer> temp, int index) {
    results.add(new ArrayList<>(temp));

    for (int i = index; i < weights.length; i++) {
        temp.add(weights[i]);
        dfs(weights, results, temp, i + 1);
        temp.remove(temp.size() - 1);
    }
}

// sunsets + find the maximum sum of List<Integer> that < maxCapacity
// time: O(2^n * n);
// space: O(2^n)