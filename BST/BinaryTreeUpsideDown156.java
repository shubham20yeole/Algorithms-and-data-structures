//https://leetcode.com/problems/binary-tree-upside-down
package BST;

import Utils.TreeNode;
import Utils.Utils;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeUpsideDown156 {

	TreeNode root;

	public TreeNode upsideDownBinaryTree(TreeNode root) {

		return root;
	}

	private void getQueue(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		TreeNode curr = root;

		q.add(curr);

		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			System.out.print(t.val + ", ");

			if (t.right != null)
				q.add(t.right);
			else
				System.out.print("#, ");
			if (t.left != null)
				q.add(t.left);
			else
				System.out.print("#, ");

		}

	}

	public static void transverse(TreeNode root) {
		if (root == null)
			return;

		transverse(root.left);
		System.out.print(root.val + ", ");
		transverse(root.right);

	}

	public int rob(TreeNode root) {
		int res = 0;

		return res;
	}

	public static void main(String[] args) {
		BinaryTreeUpsideDown156 tree = new BinaryTreeUpsideDown156();

		Utils utils = new Utils();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(10);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(8);
		tree.root.right.right = new TreeNode(11);

		transverse(tree.root);
		utils.printLine();

		tree.getQueue(tree.root);
		utils.printLine();
	}
}