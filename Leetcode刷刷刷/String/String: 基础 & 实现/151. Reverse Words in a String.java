class Solution {
    public String reverseWords(String s) {
        // time: O(n); space: O(n)
        if (s == null || s.length() == 0) {
            return s;
        }
        
        s = s.trim();
        String[] arr = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }
}

////////////////////////

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        
        // 相向双指针，reverse的步骤
        int left = 0, right = arr.length - 1;
        while (left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        
        // 最后， 如何将String[] 转换成String呢？
        String str = "";  //创建一个空字符串
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                str += arr[i] + " ";
            } else {
                str += arr[i];
            } 
        }
        return str;
    }
}
