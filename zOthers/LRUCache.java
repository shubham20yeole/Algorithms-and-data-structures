package zOthers;

import Utils.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		LRUCache cn = new LRUCache(2);
		cn.put(1, 1);
		cn.put(2, 2);
		cn.get(1); // returns 1
		cn.put(3, 3); // evicts key 2
		cn.get(2); // returns -1 (not found)
		cn.put(4, 4); // evicts key 1
		cn.get(1); // returns -1 (not found)
		cn.get(3); // returns 3
		cn.get(4); // returns 4
		// System.out.println(cn.generateParenthesis(3));
	}

	int size = 0, capacity;

	Map<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		System.out.println(cache);
		int ans = -1;
		if (cache.containsKey(key)) {
			ans = cache.get(key);
			cache.remove(key);
			cache.put(key, ans);
		}

		return ans;
	}

	public void put(int key, int value) {
		System.out.println(cache);
		Set<Integer> set = cache.keySet();
		int first;
		for (int i : set) {
			first = i;
			if (this.size == this.capacity) {
				cache.remove(first);
				size--;
			}
			break;
		}

		cache.put(key, value);
		size++;
	}
}
