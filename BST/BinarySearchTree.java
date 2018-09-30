//https://www.geeksforgeeks.org/binary-search-tree-data-structure/
package BST;

import java.util.*;

import Utils.*;

/**
 * @author shubham.yeole
 * @reference 
 *
 *
 */
public class BinarySearchTree {

	public static Node root;

	class Node {
		Node right, left;
		int data;

		Node(int data) {
			this.data = data;
			this.right = this.left = null;
		}
	}

	BinarySearchTree() {
		this.root = null;
	}

	private void add(int data) {

		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
			return;
		}

		Node curr = root, prev = null;

		while(true) {
			prev = curr;

			if (data > prev.data) {
				curr = curr.right;
				if (curr == null) {
					prev.right = newNode;
					return;
				}
			} else {
				curr = curr.left;
				if (curr == null) {
					prev.left = newNode;
					return;
				}
			}
		}

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.add(100);
		bst.add(110);
		bst.add(90);
		bst.add(190);
		bst.add(70);
		bst.add(95);
		bst.add(105);

		UtilsBST utils = new UtilsBST();

		utils.printLine("BST HEIGHT: " + getHeight(root)); utils.printLine();

		utils.printLine("printLevelOrder with height");
		printLevelOrder(); utils.printLine();

		utils.printLine("printLevelOrder with queue");
		printLevelOrder(root); utils.printLine(); utils.printLine();

		utils.printLine("103. Binary Tree Zigzag Level Order Traversal");
		printZigZagLevelOrder(root); utils.printLine(); utils.printLine();

		utils.printLine("recursiveInOrder");
		bst.recursiveInOrder(root); utils.printLine();
		bst.nonRecursiveInorder(root); utils.printLine(); utils.printLine();

		utils.printLine("printDiagonalOrder");
		bst.printDiagonalOrder(root); utils.printLine(); utils.printLine();

		utils.printLine("recursivePreOrder");
		bst.recursivePreOrder(root); utils.printLine();
		bst.nonRecursivePreOrder(root); utils.printLine(); utils.printLine();

		utils.printLine("recursivePostOrder");
		bst.recursivePostOrder(root); utils.printLine();
		bst.nonRecursivePostOrder(root); utils.printLine(); utils.printLine();
	}

	private static void printZigZagLevelOrder(Node root) {
		Stack<Node> s = new Stack<Node>();
		Queue<Node> q = new LinkedList<Node>();

		s.add(root);

		while (!q.isEmpty() || !s.isEmpty()) {

			while (!q.isEmpty()) {
				Node cur = q.poll();
				System.out.print(cur.data + ", ");

				if (cur.right != null) s.add(cur.right);
				if (cur.left != null) s.add(cur.left);
			}

			System.out.println();
			while (!s.isEmpty()) {
				Node cur = s.pop();
				System.out.print(cur.data + ", ");
				if (cur.right != null) q.add(cur.right);
				if (cur.left != null) q.add(cur.left);
			}
			System.out.println();
		}
	}

	public static void printLevelOrder() {
		int height = getHeight(root);
		UtilsBST utils = new UtilsBST();

		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
			utils.printLine();
		}

	}

	private static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1)
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}

	public static void printLevelOrder(Node root) {

		if (root == null) return;

		Queue<Node> q = new LinkedList<Node>();

		q.add(root);

		while (!q.isEmpty()) {

			Node curr = q.poll();
			System.out.print(curr.data + ", ");

			if (curr.left != null) q.add(curr.left);
			if (curr.right != null) q.add(curr.right);
		}
	}

	public void printDiagonalOrder(Node root) {
		if (root == null) return;

		Queue<Node> q = new LinkedList<Node>();


		while (root != null) {
			q.add(root);
			System.out.print(root.data + ", ");
			root = root.right;
		}

		while (!q.isEmpty()) {
			Node curr = q.poll();

			if (curr.left != null) {
				curr = curr.left;
				while (curr != null) {
					q.add(curr);
					System.out.print(curr.data + ", ");
					curr = curr.right;
				}
			}

		}
	}

	private static int getHeight(Node root) {
		if (root == null) return 0;

		int rh = getHeight(root.right) + 1;
		int lh = getHeight(root.left) + 1;

		return Math.max(rh, lh);
	}

	//IN ORDER:Recursion LEFT - ROOT - RIGHT	
	private void recursiveInOrder(Node root) {
		if(root != null) {
			recursiveInOrder(root.left);
			System.out.print(root.data + ", ");
			recursiveInOrder(root.right);
		}
	}

	//IN ORDER: LEFT - ROOT - RIGHT	
	private void nonRecursiveInorder(Node root) {
		if (root == null) return;

		Stack<Node> s = new Stack<Node>();

		Node curr = root;
		while (curr != null || s.size() > 0) {

			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}

			curr = s.pop();
			System.out.print(curr.data + ", ");
			curr = curr.right;
		}
	}

	//PRE ORDER: RECURSION ROOT - LEFT - RIGHT	
	private void recursivePreOrder(Node root) {
		if(root != null) {
			System.out.print(root.data + ", ");
			recursivePreOrder(root.left);
			recursivePreOrder(root.right);
		}
	}

	//IN ORDER: LEFT - ROOT - RIGHT	
	private void nonRecursivePreOrder(Node root) {
		if (root == null) return;

		Stack<Node> s = new Stack<Node>();

		Node curr = root;
		while (curr != null || s.size() > 0) {

			while (curr != null) {
				System.out.print(curr.data + ", ");
				s.push(curr);
				curr = curr.left;
			}

			curr = s.pop();
			curr = curr.right;
		}
	}

	//POST ORDER: LEFT - RIGHT - ROOT	
	private void recursivePostOrder(Node root) {
		if(root != null) {
			recursivePostOrder(root.left);
			recursivePostOrder(root.right);
			System.out.print(root.data + ", ");
		}
	}

	//POST ORDER: LEFT - RIGHT - ROOT	
	private void nonRecursivePostOrder(Node root) {
		if(root == null) return;

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(root);

		while(!s1.isEmpty()) {
			Node curr = s1.pop();

			if(curr.left != null) s1.push(curr.left);
			if(curr.right != null) s1.push(curr.right);

			s2.push(curr);
		}

		while ( !s2.isEmpty()) {
			System.out.print(s2.pop().data + ", ");
		}
	}

	public List<List<Integer>> zigzagLevelOrder(Node root) {
		
		int height = getHeight(root);
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		
		for (int i = 0; i < height; i++) {
			List<Integer> sa = new LinkedList<Integer>();
			
			sa = getZigzagLevelOrder(root, i, sa);
			
			if(i % 2 != 0) Collections.reverse(sa);
			
			ans.add(sa);
		}
		return ans;
	}
	
	private static List<Integer> getZigzagLevelOrder(Node root, int level, List<Integer> sa) {
		if (root == null)
			return sa;
		if (level == 1)
			sa.add(root.data);
		else if (level > 1)
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
		return sa;
	}
}
