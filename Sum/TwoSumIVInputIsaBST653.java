//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
package Sum;

import Utils.TreeNode;
import java.util.HashSet;

public class TwoSumIVInputIsaBST653 {

	public boolean findTarget(TreeNode root, int k) {
		return recursion(root, k, new HashSet<Integer>());
	}

	public boolean recursion(TreeNode root, int k, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (set.contains(k - root.val))
			return true;

		set.add(root.val);

		boolean left = recursion(root.left, k, set);
		boolean right = recursion(root.right, k, set);

		if (left || right)
			return true;

		return false;
	}
}
