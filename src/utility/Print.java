package utility;

import java.util.List;

public final class Print {
	public static void printInt2DArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
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
}
