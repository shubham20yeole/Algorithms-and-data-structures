//https://www.geeksforgeeks.org/binary-search-tree-data-structure/
package Utils;

import java.util.*;
import Utils.*;

/**
 * @author shubham.yeole
 * @reference 
 *
 *
 */
public class UtilsBST extends Utils{

	public static TreeNode root;

	public UtilsBST() {
		this.root = null;
	}

	public void add(int data) {

		TreeNode newNode = new TreeNode(data);

		if (root == null) {
			root = newNode;
			return;
		}

		TreeNode curr = root, prev = null;

		while(true) {
			prev = curr;

			if (data > prev.val) {
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

	public static void printZigZagLevelOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		s.add(root);

		while (!q.isEmpty() || !s.isEmpty()) {

			while (!q.isEmpty()) {
				TreeNode cur = q.poll();
				System.out.print(cur.val + ", ");

				if (cur.right != null) s.add(cur.right);
				if (cur.left != null) s.add(cur.left);
			}

			System.out.println();
			while (!s.isEmpty()) {
				TreeNode cur = s.pop();
				System.out.print(cur.val + ", ");
				if (cur.right != null) q.add(cur.right);
				if (cur.left != null) q.add(cur.left);
			}
			System.out.println();
		}
	}

	public static void printLevelOrder(TreeNode root) {
		int height = getHeight(root);
		UtilsBST utils = new UtilsBST();

		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}

	}

	public static void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.val + " ");
		else if (level > 1)
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}

	public void printDiagonalOrder(TreeNode root) {
		if (root == null) return;

		Queue<TreeNode> q = new LinkedList<TreeNode>();


		while (root != null) {
			q.add(root);
			System.out.print(root.val + ", ");
			root = root.right;
		}

		while (!q.isEmpty()) {
			TreeNode curr = q.poll();

			if (curr.left != null) {
				curr = curr.left;
				while (curr != null) {
					q.add(curr);
					System.out.print(curr.val + ", ");
					curr = curr.right;
				}
			}

		}
	}

	public static int getHeight(TreeNode root) {
		if (root == null) return 0;

		int rh = getHeight(root.right) + 1;
		int lh = getHeight(root.left) + 1;

		return Math.max(rh, lh);
	}

	//IN ORDER:Recursion LEFT - ROOT - RIGHT	
	public void recursiveInOrder(TreeNode root) {
		if(root != null) {
			recursiveInOrder(root.left);
			System.out.print(root.val + ", ");
			recursiveInOrder(root.right);
		}
	}

	//PRE ORDER: RECURSION ROOT - LEFT - RIGHT	
	public void recursivePreOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.val + ", ");
			recursivePreOrder(root.left);
			recursivePreOrder(root.right);
		}
	}

	//POST ORDER: LEFT - RIGHT - ROOT	
	public void recursivePostOrder(TreeNode root) {
		if(root != null) {
			recursivePostOrder(root.left);
			recursivePostOrder(root.right);
			System.out.print(root.val + ", ");
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
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
	
	public static List<Integer> getZigzagLevelOrder(TreeNode root, int level, List<Integer> sa) {
		if (root == null)
			return sa;
		if (level == 1)
			sa.add(root.val);
		else if (level > 1)
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
		return sa;
	}
}
