/*
 * LeetCode #707. Design Linked List
 * happygirlzt
 * Created on 16 July 2018
 */

public class MyLinkedList {
	// nested class
	private static class ListNode {
		private int val;
		private ListNode next;

		private ListNode(int v) {
			this.val = v;
			this.next = null;
		}

		private ListNode(int v, ListNode n) {
			this.val = v;
			this.next = n;
		}
	}

	private ListNode head;
	// private int length;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = null;
	}

	/* Return the length of the linked list */
	public int getLength() {
		if (head == null)
			return 0;

		ListNode tmp = head;
		int count = 0;

		while (tmp != null) {
			tmp = tmp.next;
			count++;
		}
		return count;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (head == null)
			return 0;

		if (index > getLength() - 1 || index < 0)
			return -1;

		ListNode tmp = head;

		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}

		if (tmp == null)
			return -1;

		return tmp.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list.
	 * After the insertion, the new node will be the first node of the linked
	 * list.
	 */
	public void addAtHead(int val) {
		ListNode dummy = new ListNode(val);
		dummy.next = head;
		head = dummy;
		// head = new ListNode(val, head);
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		ListNode newNode = new ListNode(val);

		if (head == null) {
			addAtHead(val);
		} else {

			ListNode tmp = head;

			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If
	 * index equals to the length of linked list, the node will be appended to
	 * the end of linked list. If index is greater than the length, the node
	 * will not be inserted.
	 */
	public void addAtIndex(int index, int val) {

		ListNode newNode = new ListNode(val);

		if (index == getLength()) {
			addAtTail(val);
		} else if (index < getLength()) {
			int count = 1;
			ListNode tmp = head;
			while (tmp != null) {
				if (count == index) {
					newNode.next = tmp.next;
					tmp.next = newNode;
					break;
				} else {
					tmp = tmp.next;
					count++;
				}
			}
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index < getLength()) {
			ListNode tmp = head;

			int count = 1;
			while (tmp != null) {
				if (count < index) {
					tmp = tmp.next;
					count++;

				} else if (count == index) {
					tmp.next = tmp.next.next;
					break;
				}
			}
		}
	}

	/** Display **/
	public void display() {
		ListNode tmp = this.head;

		while (tmp != null) {
			System.out.print(tmp.val + " -> ");
			tmp = tmp.next;
		}

		System.out.println(tmp);
	}

	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtHead(1);
		// obj.display();
		obj.addAtTail(3);
		// obj.display();
		obj.addAtIndex(1, 2);
		// obj.addAtHead(4);
		obj.display();

		int get_1 = obj.get(1);
		System.out.println(get_1);
		// obj.addAtHead(8).display();

		obj.deleteAtIndex(1);
		obj.display();

		int get_2 = obj.get(1);
		System.out.println(get_2);
		obj.display();
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
