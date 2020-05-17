public class Remove_Element {
    /*
     * @param A: A list of integers
     * 
     * @param elem: An integer
     * 
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // 两根指针，fast指针遍历整个数组A
        // 把所有的不等于value的元素移到slow指针的位置，同时slow++
        // 时间复杂度O(n), 空间复杂度O(1)
        if (A == null || A.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        while (fast < A.length) {
            if (A[fast] != elem) {
                A[slow] = A[fast];
                slow += 1;
            }
            fast += 1;
        }
        return slow;
    }
}