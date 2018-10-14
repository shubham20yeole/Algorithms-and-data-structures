//https://www.geeksforgeeks.org/binary-search-tree-data-structure/
package BST;

import java.util.Stack;

class Node {
	int data;
	Node left, right;

	Node(int value) {
		data = value;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	int findLCA(int n1, int n2) {
		return findLCA(root, n1, n2).data;
	}

	private Node findLCA(Node root, int n1, int n2) {

		if (root == null)
			return null;

		if (root.data == n1 || root.data == n2)
			return root;

		Node leftLCA = findLCA(root.left, n1, n2);
		Node rightLCA = findLCA(root.right, n1, n2);

		if (leftLCA != null && rightLCA != null)
			return root;

		return leftLCA == null ? rightLCA : leftLCA;
	}

	boolean isValidBST(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <= max.
	 */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}

	private int[] getMinAndMax(Node root) {
		if (root == null)
			return new int[] { 0, 0 };

		int[] res = new int[2];
		res[0] = root.data;
		res[1] = root.data;
		Stack<Node> s = new Stack<Node>();
		Node curr = root;
		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.push(curr);
				res[0] = Math.min(res[0], curr.data);
				res[1] = Math.max(res[1], curr.data);
				curr = curr.left;
			}

			curr = s.pop();
			curr = curr.right;
		}

		return res;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("LCA(4, 5): " + tree.findLCA(4, 5));
		System.out.println("LCA(4, 6): " + tree.findLCA(4, 6));
		System.out.println("LCA(3, 4): " + tree.findLCA(3, 4));
		System.out.println("LCA(2, 4): " + tree.findLCA(2, 4));
		/*
		 * System.out.println("LCA(4, 7): " + tree.findLCA(4,7));
		 * System.out.println("LCA(4, 8): " + tree.findLCA(4,8));
		 * System.out.println("LCA(1, 1): " + tree.findLCA(1,1));
		 */

		BinaryTree tree2 = new BinaryTree();
		tree2.root = new Node(1);
		tree2.root.right = new Node(1);

		System.out.println(tree.isValidBST(tree2.root));
		System.out.println(tree.isValidBST(tree.root));
	}
}