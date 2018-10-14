//https://leetcode.com/problems/merge-intervals
package Array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals56 {

	public static void main(String[] args) {
		MergeIntervals56 mi = new MergeIntervals56();
		List<Interval> intervals = new LinkedList<Interval>();
		intervals.add(new Interval(1, 1));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(19, 20));
		intervals.add(new Interval(2, 18));

		mi.merge(intervals).forEach(item -> {
			System.out.println(item.getStart() + " - " + item.getEnd());
		});

	}

	@SuppressWarnings("unchecked")
	public List<Interval> merge(List<Interval> ivs) {

		if (ivs.size() == 0)
			return new LinkedList<Interval>();

		Collections.sort(ivs);

		Interval pi = ivs.get(0);
		Interval ci = null;

		for (int i = 1; i < ivs.size(); i++) {
			ci = ivs.get(i);

			if (pi.getEnd() >= ci.getStart()) {
				pi.setEnd(Math.max(ci.getEnd(), pi.getEnd()));
				ivs.remove(i--);
				continue;
			}

			pi = ci;
		}

		return ivs;
	}

}

class Interval implements Comparable {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public int getStart() {
		return this.start;
	}

	public int getEnd() {
		return this.end;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int compareTo(Object obj) {
		return this.start - ((Interval) obj).getStart();
	}
}