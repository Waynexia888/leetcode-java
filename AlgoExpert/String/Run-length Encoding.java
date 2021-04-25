import java.util.*;

class Program {
  public String runLengthEncoding(String string) {
    // Write your code here.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			int count = 1;
			// count how many times the same character appear
			while (i < string.length() - 1 && c == string.charAt(i + 1)) {
				count++;
				i++;
			}
			
			// there is a case: 9A9A3A
			while (count > 9) {
				sb.append(Integer.toString(9)).append(c);
				count -= 9;
			}
			sb.append(Integer.toString(count)).append(c);
		}
		
    return sb.toString();
  }
}
