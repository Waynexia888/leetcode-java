import java.util.*;

class Program {
  public static String caesarCypherEncryptor(String str, int key) {
    // Write your code here.
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int index = (alphabet.indexOf(c) + key) % 26;
			c = alphabet.charAt(index);
			sb.append(c);
		}
		
    return sb.toString();
  }
}

// abcdefghijklmnopqrstuvwxyz
// xyz
// (23 + 2) % 26 = 25