package tuf.arrays1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/description/
// https://www.youtube.com/watch?v=nPVEaB3AjUM
public class _118_PascalsTriangle {

	public static void print(List<List<Integer>> data) {
		for (List<Integer> it : data) {
			for (int ele : it) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> innerFirstList = new ArrayList<Integer>();
		innerFirstList.add(1);
		result.add(innerFirstList);

		for (int i = 0; i < numRows - 1; i++) {
			// deep copying last row of result array of arrays
			ArrayList<Integer> tempRow = new ArrayList<Integer>();
			ArrayList<Integer> lastRow = (ArrayList<Integer>) result.getLast();
			Iterator<Integer> it = lastRow.iterator();
			while (it.hasNext()) {
				tempRow.add(it.next());
			}

			tempRow.addFirst(0);
			tempRow.addLast(0);

			ArrayList<Integer> currentRow = new ArrayList<Integer>();

			for (int j = 0; j < tempRow.size() - 1; j++) {
				currentRow.add(tempRow.get(j) + tempRow.get(j + 1));
			}

			result.add(currentRow);
		}

		return result;
	}

	public static void main(String[] args) {
		_118_PascalsTriangle obj = new _118_PascalsTriangle();

		print(obj.generate(5));
	}

}
