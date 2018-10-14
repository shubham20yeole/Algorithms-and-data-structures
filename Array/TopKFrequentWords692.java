//https://leetcode.com/problems/top-k-frequent-words/description/
package Array;

import Utils.Utils;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentWords692 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		TopKFrequentWords692 cn = new TopKFrequentWords692();

		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 3;
		System.out.println(cn.topKFrequent(words, k));

	}

	public List<String> topKFrequent(String[] words, int k) {
		List<String> ans = new LinkedList<String>();

		Map<String, Integer> map = new TreeMap<String, Integer>();

		for (String word : words) {
			map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
		}

		PriorityQueue<Element> pq = new PriorityQueue<Element>(words.length, (item, item2) -> {
			if (item.frequency == item2.frequency) {
				return item.word.compareTo(item2.word);
			}
			if (item.frequency > item2.frequency)
				return -1;
			return 1;
		});

		for (String word : map.keySet()) {
			Element el = new Element(map.get(word), word);
			pq.add(el);
		}
		System.out.println(pq);

		List<Element> t = new LinkedList<Element>(pq);
		t.forEach((element) -> {
			System.out.print(element.frequency + " - " + element.word + ", ");
		});
		System.out.println();
		for (int i = 0; i < k; i++) {
			ans.add(pq.poll().word);
		}

		return ans;
	}

	class Element {
		int frequency;
		String word;

		public Element(int frequency, String word) {
			this.frequency = frequency;
			this.word = word;
		}

		public void set(int frequency, String word) {
			this.frequency = frequency;
			this.word = word;
		}

		public Element get() {
			return this;
		}

	}
}
