import java.util.*;

class Program {
  public static boolean isPalindrome(String str) {
    // Write your code here.
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
    return true;
  }
}
