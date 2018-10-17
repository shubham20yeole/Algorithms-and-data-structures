//https://leetcode.com/problems/binary-tree-vertical-order-traversal/
package BST;

import Utils.TreeNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTransversal314 {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		if (root == null)
			return ans;

		Map<Integer, List<Element>> map = new TreeMap<Integer, List<Element>>();

		verticalOrder(root, 0, map, 0);

		for (Integer key : map.keySet()) {

			List<Element> lis = new LinkedList<Element>(map.get(key));
			Collections.sort(lis);

			List<Integer> subAns = new LinkedList<Integer>();

			for (Element e : lis) {
				subAns.add(e.e);
			}

			ans.add(subAns);
		}
		return ans;
	}

	public void verticalOrder(TreeNode root, int count, Map<Integer, List<Element>> map, int level) {
		if (root == null)
			return;

		List<Element> list;
		if (map.containsKey(count)) {
			list = new LinkedList<Element>(map.get(count));
		} else {
			list = new LinkedList<Element>();
		}
		list.add(new Element(level, root.val));
		map.put(count, list);
		verticalOrder(root.left, count - 1, map, level + 1);
		verticalOrder(root.right, count + 1, map, level + 1);

	}

	class Element implements Comparable {
		int l;
		int e;

		public Element(int l, int e) {
			this.e = e;
			this.l = l;
		}

		public Element get() {
			return this;
		}

		@Override
		public int compareTo(Object element) {
			return this.l - ((Element) element).l;
		}
	}
}