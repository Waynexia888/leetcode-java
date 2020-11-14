import java.util.*;

class Program {
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    // time: O(n); space: O(1)
		int length = 1;
		LinkedList index = head;
		while (index.next != null) {
			index = index.next;
			length++;
		}
		index.next = head;
		
		for (int i = 1; i < length - (k % length); i++) {
			head = head.next;
		}
		
		LinkedList result = head.next;
		head.next = null;
		
    return result;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
