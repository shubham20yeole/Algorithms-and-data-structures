//https://www.geeksforgeeks.org/binary-search-tree-data-structure/
package BST;

import Utils.TreeNode;
import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> st = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		TreeNode curr = root;

		while (curr != null) {
			st.push(curr);
			curr = curr.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return st.size() > 0 ? true : false;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode curr = st.pop();
		TreeNode res = curr;

		if (curr.right != null) {
			curr = curr.right;
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
		}

		return res.val;
	}

}
