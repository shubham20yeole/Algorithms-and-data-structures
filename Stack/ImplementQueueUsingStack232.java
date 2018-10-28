//https://leetcode.com/problems/implement-queue-using-stacks/
package Stack;

import java.util.Stack;

public class ImplementQueueUsingStack232 {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	/** Initialize your data structure here. */
	public ImplementQueueUsingStack232() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		s1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}

		int ans = s2.pop();

		if (!s2.isEmpty()) {
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
		return ans;
	}

	/** Get the front element. */
	public int peek() {
		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}

		int ans = s2.peek();

		if (!s2.isEmpty()) {
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
		return ans;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s1.isEmpty();
	}
}
