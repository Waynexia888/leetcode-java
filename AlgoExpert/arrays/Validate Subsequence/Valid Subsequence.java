import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // time: O(n); space: O(1)
		int arrIndex = 0, seqIndex = 0;
		
		while (arrIndex < array.size() && seqIndex < sequence.size()) {
			if (array.get(arrIndex) == sequence.get(seqIndex)) {
				seqIndex++;
			}
			arrIndex++;
		}
		
		if (seqIndex == sequence.size()) {
			return true;
		}
    return false;
  }
}

//////////////////////////////////////////////////////////////////

import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // time: O(n); space: O(1)
		int seqIndex = 0;
		
		for (int i = 0; i < array.size(); i++) {
			if (seqIndex == sequence.size()) {
				break;
			}
			if (array.get(i) == sequence.get(seqIndex)) {
				seqIndex++;
			}
		}
    return seqIndex == sequence.size();
  }
}
