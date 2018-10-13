//https://leetcode.com/problems/flatten-binary-tree-to-linked-list
package BST;
import java.util.*;
import Utils.*;

public class FlattenBinaryTreetoLinkedList114 {

	static UtilsBST utils = new UtilsBST();

	UtilsBST util = new UtilsBST();

  TreeNode root; 

  
	public static void main(String[] args) {

		FlattenBinaryTreetoLinkedList114 tree = new FlattenBinaryTreetoLinkedList114();
    tree.root = new TreeNode(1); 
    tree.root.left = new TreeNode(2); 
    tree.root.right = new TreeNode(5); 
    tree.root.left.left = new TreeNode(3); 
    tree.root.left.right = new TreeNode(4); 
    tree.root.right.right = new TreeNode(6); 

    utils.printLevelOrder(tree.root);
    
    tree.flatten(tree.root); utils.printLine();

    utils.printLevelOrder(tree.root);

	}
	
	
	public void flatten(TreeNode root) {
		if(root == null) return;
		
		TreeNode right = root.right;
		TreeNode left = root.left;
		
		root.left = null;

		flatten(left);
    flatten(right);
    
    root.right = left;
    TreeNode cur = root;
    while (cur.right != null) cur = cur.right;
    cur.right = right;
  }
}

