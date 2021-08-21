// [1,4,3,4,9], 按照大小重新给从1开始的priority，得到结果 [1,3,2,3,4]

public List<Integer> minPriority(List<Integer> arr) {
    List<Integer> results = new ArrayList<>();
    TreeSet<Integer> ts = new TreeSet<>();
    for (Inetger val : arr) {
        ts.add(val);
    }

    Map<Integer, Integer> map = new HashMap<>();
    int priority = 1;
    for (int v : ts) {
        map.put(v, priority);
        priority++;
    }

    for (Integer n : arr) {
        results.add(map.get(n));
    }
    return results;
}

// time: O(nlogn); space: o(n)

// HashSet是由一个hash表来实现的，     因此，它的元素是无序的。       
// add()，remove()，contains()方法的时间复杂度是O(1)。

// TreeSet contains unique value, and maintains ascending order
// TreeSet是由一个树形的结构来实现的，它里面的元素是有序的。
// 因此，add()，remove()，contains()方法的时间复杂度是O(logn)。

