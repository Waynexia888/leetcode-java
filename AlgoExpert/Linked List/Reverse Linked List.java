import java.util.*;

class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
    // time: O(n); space: O(1)
		LinkedList pre = null;
		while (head != null) {
			LinkedList temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
    return pre;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
