class Solution {
    public String reverseWords(String s) {
        // time: O(n); space: o(n)
        if (s == null || s.length() == 0) return s;
        
        char[] arr = s.toCharArray();
        int j = 0;
        while (j < arr.length) {
            int i = j;
            while (j < arr.length && arr[j] != ' ') {
                j++;
            }
            reverse(arr, i, j - 1);
            j++;
            i = j;
        }
        return String.valueOf(arr);
    }
    
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

///////////////two pointer, use for loop////////////////
class Solution {
    public String reverseWords(String s) {
        // time: O(n); space: o(n)
        if (s == null || s.length() == 0) return s;
        
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
        }
        
        // reverse the last word
        reverse(arr, i, arr.length - 1);
        
        return String.valueOf(arr);
    }
    
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

////////////////use split("") method + StringBuilder ///////////////
class Solution {
    public String reverseWords(String s) {
        // time: O(n); space: o(n)
        if (s == null || s.length() == 0) return s;
        
        String[] arr = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            String str = new StringBuilder(arr[i]).reverse().toString();
            sb.append(str + " ");
        }
        return sb.toString().trim();
    }
}