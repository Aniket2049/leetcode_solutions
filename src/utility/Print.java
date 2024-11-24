package utility;

import java.util.List;

public final class Print {
	public static void printInt2DArray(int[][] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[");
			for (int j = 0; j < arr[i].length; j++) {
				if (j == arr[i].length - 1) {
					System.out.print(arr[i][j]);
				} else {
					System.out.print(arr[i][j] + ",");
				}
			}
			System.out.print("]");
		}
		System.out.print("]");
		System.out.println();
	}

	public static void printStringListOfLists(List<List<String>> listOfList) {
		for (int i = 0; i < listOfList.size(); i++) {
			List<String> currentString = listOfList.get(i);

			for (int j = 0; j < currentString.size(); j++) {
				System.out.print(currentString.get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void printIntListOfLists(List<List<Integer>> listOfList) {
		for (int i = 0; i < listOfList.size(); i++) {
			List<Integer> currentString = listOfList.get(i);

			for (int j = 0; j < currentString.size(); j++) {
				System.out.print(currentString.get(j) + " ");
			}
			System.out.println();
		}
	}
}
