//https://leetcode.com/problems/nested-list-weight-sum-ii
package Bucket;

import Utils.Utils;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
	// Constructor initializes an empty nested list.
	Integer value;

	public NestedInteger() {
	}

	// Constructor initializes a single integer.
	public NestedInteger(int value) {
	}

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger() {
		return false;
	}

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return null;
	}

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {
	}

	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni) {
	}

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return null;
	}
}

public class NestedListWeightSumII364 {
	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		NestedListWeightSumII364 cn = new NestedListWeightSumII364();

		utils.printLine();

	}

	public int depthSumInverse(List<NestedInteger> nestedList) {
		return 0;
	}
}