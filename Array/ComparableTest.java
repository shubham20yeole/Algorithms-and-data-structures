//
package Array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ComparableTest {

	public static void main(String[] args) {
		ComparableTest cn = new ComparableTest();
		cn.someTest();

	}

	public void someTest() {
		List<LendingClub> list = new LinkedList<LendingClub>();

		list.add(new LendingClub(100000, 900, "Shubham"));
		list.add(new LendingClub(5000, 50, "Rahul"));
		list.add(new LendingClub(7000, 45, "Zara"));

		System.out.println("\nNon sorted list");
		list.forEach(item -> System.out.println(item.name + " - " + item.income + " - " + item.saving));
		System.out.println();

		System.out.println("\nComparable sort");
		Collections.sort(list);
		list.forEach(item -> System.out.println(item.name + " - " + item.income + " - " + item.saving));

		System.out.println("\nComparator sort by name");
		Collections.sort(list, (object1, object2) -> object1.name.compareTo(object2.name));
		list.forEach(item -> System.out.println(item.name + " - " + item.income + " - " + item.saving));

		System.out.println("\nComparator sort by saving");
		Collections.sort(list, (object1, object2) -> object1.saving - object2.saving);
		list.forEach(item -> System.out.println(item.name + " - " + item.income + " - " + item.saving));
	}

	class LendingClub implements Comparable {
		int income;
		int saving;
		String name;

		public LendingClub(int income, int saving, String name) {
			this.name = name;
			this.saving = saving;
			this.income = income;
		}

		@Override
		public int compareTo(Object o) {
			return this.saving - ((LendingClub) o).saving;
		}

	}

}
