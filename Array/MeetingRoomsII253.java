//https://leetcode.com/problems/meeting-rooms-ii
package Array;

import java.util.Arrays;

/**
 * @author shubham.yeole
 * @reference https://leetcode.com/problems/meeting-rooms-ii/description/
 *
 *            Given an array of meeting time intervals consisting of start and
 *            end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number
 *            of conference rooms required.
 * 
 *            Example 1: Input: [[0, 30],[5, 10],[15, 20]] Output: 2
 * 
 *            start 0 5 15 end 10 20 30
 * 
 *            Example 2: Input: [[7,10],[2,4]] Output: 1
 *
 */
public class MeetingRoomsII253 {
	public static void main(String[] args) {

	}

	public int minMeetingRooms(Interval[] intervals) {
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		int pos = 0;
		for (Interval interval : intervals) {
			start[pos] = interval.start;
			end[pos] = interval.end;
			pos++;
		}

		Arrays.sort(start);
		Arrays.sort(end);

		int p1 = 0, p2 = 0, rooms = intervals.length;

		while (p1 < intervals.length && p2 < intervals.length) {
			if (end[p2] <= start[p1]) {
				rooms--;
				p2++;
			}

			p1++;
		}

		return rooms;
	}
}

// 0,1 - 0,10 - 2, 12