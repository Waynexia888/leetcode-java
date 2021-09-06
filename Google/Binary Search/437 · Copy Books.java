Lintcode 437 · Copy Books

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }

        // pages = [3, 2, 4]
        // 如果只有一个抄书员，最少需要4单位时间(即只抄1本书),最多需要9单位时间(即所有书都抄)
        int start = 0, end = 0;
        int sum = 0;
        for (int page : pages) {
            start = Math.max(start, page);
            sum += page;
            end = Math.max(end, sum);
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 如果k个抄书员能在mid单位时间内，抄完所有的书; (例如5个单位时间能抄完，那么6个单位时间也可以抄完)
            if (check(pages, mid, k)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (check(pages, start, k)) {
            return start;
        }

        if (check(pages, end, k)) {
            return end;
        }
        return 0;  
    }

    private boolean check(int[] pages, int time, int k) {
        int numberOfCopiers = 1;
        int currentPage = pages[0]; 

        for (int i = 1; i < pages.length; i++) {
            if (currentPage + pages[i] > time) {
                numberOfCopiers++;
                currentPage = pages[i];
            } else {
                currentPage += pages[i];
            }
        }
        return numberOfCopiers <= k;
    }
}