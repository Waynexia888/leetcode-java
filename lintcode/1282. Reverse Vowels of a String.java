public class Reverse_Vowels_of_a_String {
    /**
     * @param s: a string
     * @return: reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        // string是不能修改的
        // 因此可以使用toCharArray()来把string变成数组
        // 使用.toCharArray()将字符串转换成字符数组
        // 使用String.valueOf()将字符数组转换成字符串
        // 参考资料： https://blog.csdn.net/u013555719/article/details/86095195
        if (s == null || s.length() < 2) {
            return s;
        }

        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !vowels.contains(chars[left] + "")) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right] + "")) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}