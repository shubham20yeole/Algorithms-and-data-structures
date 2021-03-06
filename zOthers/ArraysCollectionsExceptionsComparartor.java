//https://www.mkyong.com/java8/java-8-lambda-comparator-example/
package zOthers;

import Utils.Utils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArraysCollectionsExceptionsComparartor {

	public static void main(String[] args) {

		// LinkedHashMap
		Map<Integer, Integer> order = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			order.put(i, i);
		}

		// System.out.println(order);

		// order.remove(5);
		System.out.println(order);
		order.put(5, 55);
		System.out.println(order);

		// ROUGH SPACE START
		String test = "1.32.3.3";
		System.out.println(Arrays.toString(test.split("\\.")));

		test = "9//99//";
		System.out.println(Arrays.toString(test.split("/")));
		System.out.println(test.split("/").length);

		Map<Student, Integer> testMap = new HashMap<Student, Integer>();
		testMap.put(new Student(1, "Shubham"), 1);
		testMap.put(new Student(1, "Shubham"), 2);
		testMap.forEach((key, value) -> {
			System.out.println(key.id + ": " + key.name + " - " + value);
		});
		// ROUGH SPACE END

		Utils du = new Utils();

		// Arrays Demo class
		DemoArrays();

		// COMPARABLE
		Student s1 = new Student(1, "Shubham");
		Student s2 = new Student(2, "Akhil");
		Student s3 = new Student(3, "Billi");

		List<Student> stList = new LinkedList<Student>(Arrays.asList(new Student[] { s1, s2, s3 }));

		Collections.sort(stList);

		stList.forEach(item -> {
			System.out.printf("id: %s, name: %s\n", item.getId(), item.getName());
		});
		du.printLine();

		stList.sort((Student stu1, Student stu2) -> stu1.getId() - stu2.getId());

		stList.forEach(item -> {
			System.out.printf("id: %s, name: %s\n", item.getId(), item.getName());
		});

		DemoException();
	}

	private static void DemoArrays() {
		int[] array = { 13, 232, 334, 324, 15, 56, 97, 224, 567, 657 };

		Arrays.sort(array);
		Arrays.toString(array);
		Arrays.asList(array);
		Arrays.binarySearch(array, 13);
		Arrays.binarySearch(array, 1, 4, 15);
		System.out.println(Arrays.binarySearch(array, 13));
	}

	private static void DemoException() {

		String s = "Shubham";

		try {
			System.out.println(30 / 0);
		} catch (ArithmeticException e) {
			System.out.println("Hello: " + e);
		}
	}
}

class Student implements Comparable {
	public int id;
	public String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public int compareTo(Object st) {

		String newName = ((Student) st).getName();

		return this.name.compareTo(newName);
	}
}