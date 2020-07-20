public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // 本题巧妙的使用相向双指针，一头一尾，进行3次reverse
        // 先局部rotate，再整体rotate
        if (str == null || str.length == 0) {
            return;
        }
        
        int n = str.length;
        offset = offset % n;
        
        // abcd efg = reverse(abcd) + reverse(efg) = dcba + gfe => reverse(dcba gfe) = efgabcd;
        reverse(str, 0, n - offset - 1);
        reverse(str, n - offset, n - 1);
        reverse(str, 0, n - 1);
    }
    
    private void reverse(char[] str, int start, int end) {
        int left = start, right = end;
        while (left <= right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}