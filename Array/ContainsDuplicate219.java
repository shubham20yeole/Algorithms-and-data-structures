//
package Array;

import Utils.Utils;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ContainsDuplicate219 {
	static Utils utils = new Utils();
	Utils util = new Utils();

	public static void main(String[] args) {
		ContainsDuplicate219 cn = new ContainsDuplicate219();

		System.out.println(cn.containsDuplicateII(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(cn.containsDuplicateII(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(cn.containsDuplicateII(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
	}

	@SuppressWarnings("unchecked")
	public boolean containsDuplicateII(int[] numbers, int k) {
		List<DataSet> list = new LinkedList<DataSet>();
		int i = 0;
		for (int n : numbers)
			list.add(new DataSet(n, i++));

		Collections.sort(list);
		// list.forEach(item -> System.out.println(item.data + " - " + item.index));

		if (list.size() <= 1)
			return false;

		DataSet pre = list.get(0);
		for (i = 1; i < list.size(); i++) {
			DataSet curr = list.get(i);
			if (pre.data == curr.data && Math.abs(pre.index - curr.index) == Math.abs(k)) {
				return true;
			}
			pre = curr;
		}

		return false;
	}

	class DataSet implements Comparable {
		int data;
		int index;

		public DataSet(int data, int index) {
			this.data = data;
			this.index = index;
		}

		public DataSet getData() {
			return this;
		}

		@Override
		public int compareTo(Object o) {
			return this.data - ((DataSet) o).data;
		}
	}
}
