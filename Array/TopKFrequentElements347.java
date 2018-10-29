//https://leetcode.com/problems/top-k-frequent-elements/
package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> ans = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
		}

		PriorityQueue<EleCount> pq = new PriorityQueue<EleCount>();

		for (Integer key : map.keySet()) {
			pq.add(new EleCount(key, map.get(key)));
		}

		while (k != 0) {
			ans.add(pq.poll().element);
			k--;
		}

		return ans;
	}

	class EleCount implements Comparable {
		int element;
		int count;

		EleCount(int element, int count) {
			this.element = element;
			this.count = count;
		}

		public EleCount getElement() {
			return this;
		}

		@Override
		public int compareTo(Object element) {
			return ((EleCount) element).getElement().count - this.count;
		}
	}
}
