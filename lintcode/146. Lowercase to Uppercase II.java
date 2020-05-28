public class Lowercase_to_Uppercase_II {
    /**
     * @param str: A string
     * @return: A string
     */
    public String lowercaseToUppercase2(String str) {
        // 遍历str，判断当前字符是否是字符或者是数字， 返回一个新的字符串
        // 时间复杂度O(n), 空间复杂度O(n)
        // String newStr = "";
        // for (int i = 0; i < str.length(); i++) {
        // if (Character.isLetter(str.charAt(i))) {
        // newStr += Character.toUpperCase(str.charAt(i));
        // } else {
        // newStr += str.charAt(i);
        // }
        // }

        // return newStr;

        // 使用StringBuilder 来修改字符串, 并且不产生新的未使用对象
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isLetter(sb.charAt(i))) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }
        }
        return sb.toString();
    }
}