//https://leetcode.com/problems/house-robber-iii
package BST;

import java.util.*;

import Utils.*;

class HouseRobberIII337 {
	
	TreeNode root; 
	
	public int rob(TreeNode root) {
		
		if (root == null) return 0;
		
		int right = 0, left = 0, subleft = 0, subright = 0;
		
		if (root.left != null) {
			left = rob(root.left);
			subleft = rob(root.left.left) + rob(root.left.right);
		}
		
		if (root.right != null) {
			left = rob(root.right);
			subright = rob(root.right.left) + rob(root.right.right);
		}
		
		int sum1 = left + right;
		int sum2 = subleft + subright + root.val;
        
		return Math.max(sum2, sum1);
    }
	
	
	public static void main(String[] args) {
		HouseRobberIII337 tree = new HouseRobberIII337(); 
		
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(10); 
        tree.root.right.left = new TreeNode(8); 
        tree.root.right.right = new TreeNode(11); 
        
        System.out.println(tree.rob(tree.root));
        
	}
}