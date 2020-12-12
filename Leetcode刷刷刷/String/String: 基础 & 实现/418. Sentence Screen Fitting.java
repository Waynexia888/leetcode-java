class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = "";
        for (String word : sentence) {
            str += word + " ";
        }
        
        int len = str.length();
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (str.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && str.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }
}




完整思路如下：

把一个sentence中的所有word都加起来，单词与单词之间有个空格，组成一个新的字符串

用start来记录最终的下标位置
每次看位移一整行的距离是否正好落在这个字符串的空格位置，如果是，就start + 1， 表示开始下一个单词
如果不是的话就退后，直到遇到一个空格。

最后start / len， 表示访问了这个字符串几遍

Time: O(n);
Space: O(1)


