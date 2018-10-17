
/**
 * LeetCode 155. Min Stack
 * 
 * @author happygirlzt
 *
 */
import java.util.List;
import java.util.ArrayList;

public class MinStack {
	// My naive solution
	private List<Integer> list;

	public MinStack() {
		list = new ArrayList<>();
	}

	public void push(int x) {
		list.add(x);
	}

	public void pop() {
		list.remove(list.size() - 1);
	}

	public int top() {
		return list.get(list.size() - 1);
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			min = Math.min(min, list.get(i));
		}

		return min;
	}

	// Others' brilliant solution
	// Use node and each node record the current min value
	// 链表还是不熟啊。。。很难bug-free，熟能生巧！
	class MinStack1 {
		class Node {
			int x;
			int min;
			Node next;

			Node(int i, int j) {
				this.x = i;
				this.min = j;
			}

			Node(int i, int j, Node next) {
				this.x = i;
				this.min = j;
				this.next = next;
			}
		}

		private Node head;

		public MinStack1() {
			head = new Node(0, Integer.MAX_VALUE, null);
		}

		public void push(int x) {
			if (head == null) {
				head = new Node(x, x);
			} else {
				head = new Node(x, Math.min(head.min, x), head);
			}
		}

		public void pop() {
			if (head != null) {
				head = head.next;
			} else {
				return;
			}
		}

		public int top() {
			if (head == null) {
				return -1;
			} else {
				return head.x;
			}
		}

		public int getMin() {
			return head.min;
		}
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */