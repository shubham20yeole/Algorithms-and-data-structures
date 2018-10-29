//https://leetcode.com/problems/find-the-celebrity/
package StackQueueAndPriorityQueue;

import java.util.Stack;

public class FindTheCelebrity277 {
	public int findCelebrity(int n) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for (int i = 1; i < n; i++) {
			int a = stack.pop();
			int b = i;

			if (knows(a, b))
				stack.push(b);
			else
				stack.push(a);
		}

		System.out.println(stack.size() + " - " + stack.peek());
		int cel = stack.pop();
		for (int i = 0; i < n; i++) {
			if (i != cel && (knows(cel, i) || !knows(i, cel)))
				return -1;
		}
		return cel;
	}

	// Mock function
	public boolean knows(int a, int b) {
		return true;
	}
}
