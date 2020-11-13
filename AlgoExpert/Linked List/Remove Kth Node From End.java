import java.util.*;

class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		LinkedList slow = head;
		LinkedList fast = head;
		
		// let fast pointer move n space
		for (int i = 1; i <= k; i++) {
				fast = fast.next;
		}
		
		// if the node we supposed to removed is the head
		if (fast == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		
		// let slow pointer move to the previous node of the delete node.
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
