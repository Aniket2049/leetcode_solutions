package neetcode250.q_math;

// https://leetcode.com/problems/excel-sheet-column-title/
// https://www.youtube.com/watch?v=X_vJDpCCuoA
public class _01_168_ExcelSheetColumnTitle {
	public String convertToTitle(int columnNumber) {
		StringBuilder res = new StringBuilder();
		while (columnNumber > 0) {
			columnNumber--;
			int offset = columnNumber % 26;
			res.append((char) ('A' + offset));
			columnNumber /= 26;
		}
		return res.reverse().toString();
	}
}
