class Solution {
    public void reverseWords(char[] s) {
        // time: O(n); space: O(1)
        if (s == null || s.length == 0) return;
        
        reverse(s, 0, s.length - 1);
        int end = 0;
        while (end < s.length) {
            int start = end;
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            reverse(s, start, end - 1);  
            end++;
        }
        
    }
    
    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

///////////////////////////同向双指针另一种写法//////
class Solution {
    public void reverseWords(char[] s) {
        // time: O(n); space: O(1)
        if (s == null || s.length == 0) return;
        
        reverse(s, 0, s.length - 1);
        int start = 0, end = 0;
        while (end < s.length) {
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            reverse(s, start, end - 1);
            end++;
            start = end;
        }
        
    }
    
    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}