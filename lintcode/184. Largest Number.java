class LargestNumberComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        String s1 = str1 + str2;
        String s2 = str2 + str1;
        return s2.compareTo(s1);     //从大到小排
    }
}
public class Solution {
    /**
     * @param nums: A list of non negative integers
     * @return: A string
     */
    public String largestNumber(int[] nums) {
        // 本题的时间复杂度取决于排序,即O(nlogn);
        // 空间复杂度O(n), 因为开辟了额外的空间，将nums转换成字符串数组str
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        // 将整型数组转换成一个字符串数组
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        // 对这个字符串数组进行排序
        Arrays.sort(str, new LargestNumberComparator());
        
        // edge case: 检查是否为0
        if (str[0].equals("0")) {
            return "0";
        }
        
        // 因为return value是一个字符串，所以需要把字符串数组转换成字符串，
        // 但需要注意， 字符串是不能直接修改的，因此需要使用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        
        return sb.toString(); // 将数据以字符串的形式返回
    }
}