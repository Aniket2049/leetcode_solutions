package neetcode.arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/description/
// https://www.youtube.com/watch?v=TjFXEUCMqI8
public class _36_ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		// a set of the characters that we have already come across (excluding '.' which
		// denotes an empty space)
		Set<Character> rowSet = null;
		Set<Character> colSet = null;

		for (int i = 0; i < 9; i++) {
			// reinitialize the sets so we don't carry over found characters from the
			// previous run
			rowSet = new HashSet<>();
			colSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char r = board[i][j];
				char c = board[j][i];
				if (r != '.') {
					if (rowSet.contains(r)) {
						return false;
					} else {
						rowSet.add(r);
					}
				}
				if (c != '.') {
					if (colSet.contains(c)) {
						return false;
					} else {
						colSet.add(c);
					}
				}
			}
		}

		// block
		// loop controls advance by 3 each time to jump through the boxes
		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				// checkBlock will return true if valid
				if (!checkBlock(i, j, board)) {
					return false;
				}
			}
		}
		// passed all tests, therefore valid board
		return true;

	}

	public boolean checkBlock(int idxI, int idxJ, char[][] board) {
		Set<Character> blockSet = new HashSet<>();
		// if idxI = 3 and indJ = 0
		// rows = 6 and cols = 3
		int rows = idxI + 3;
		int cols = idxJ + 3;
		// and because i initializes to idxI but only goes to rows, we loop 3 times
		// (once for each row)
		for (int i = idxI; i < rows; i++) {
			// same for columns
			for (int j = idxJ; j < cols; j++) {
				if (board[i][j] == '.') {
					continue;
				}

				if (blockSet.contains(board[i][j])) {
					return false;
				}

				blockSet.add(board[i][j]);
			}
		}

		return true;
	}
    
	public static void main(String[] args) {
//		Input: board = 
//		{{'5','3','.','.','7','.','.','.','.'}
//		,{'6','.','.','1','9','5','.','.','.'}
//		,{'.','9','8','.','.','.','.','6','.'}
//		,{'8','.','.','.','6','.','.','.','3'}
//		,{'4','.','.','8','.','3','.','.','1'}
//		,{'7','.','.','.','2','.','.','.','6'}
//		,{'.','6','.','.','.','.','2','8','.'}
//		,{'.','.','.','4','1','9','.','.','5'}
//		,{'.','.','.','.','8','.','.','7','9'}}
//		Output: true
		
		char[][] board = new char[][]
				{{'5','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
				,{'.','9','8','.','.','.','.','6','.'}
				,{'8','.','.','.','6','.','.','.','3'}
				,{'4','.','.','8','.','3','.','.','1'}
				,{'7','.','.','.','2','.','.','.','6'}
				,{'.','6','.','.','.','.','2','8','.'}
				,{'.','.','.','4','1','9','.','.','5'}
				,{'.','.','.','.','8','.','.','7','9'}}; 
		System.out.println(new _36_ValidSudoku().isValidSudoku(board));

		
//		Example 2:
//		Input: board = 
//		[['8','3','.','.','7','.','.','.','.'}
//		,{'6','.','.','1','9','5','.','.','.'}
//		,{'.','9','8','.','.','.','.','6','.'}
//		,{'8','.','.','.','6','.','.','.','3'}
//		,{'4','.','.','8','.','3','.','.','1'}
//		,{'7','.','.','.','2','.','.','.','6'}
//		,{'.','6','.','.','.','.','2','8','.'}
//		,{'.','.','.','4','1','9','.','.','5'}
//		,{'.','.','.','.','8','.','.','7','9'}}
//		Output: false
		
		board = new char[][]
				{{'8','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
				,{'.','9','8','.','.','.','.','6','.'}
				,{'8','.','.','.','6','.','.','.','3'}
				,{'4','.','.','8','.','3','.','.','1'}
				,{'7','.','.','.','2','.','.','.','6'}
				,{'.','6','.','.','.','.','2','8','.'}
				,{'.','.','.','4','1','9','.','.','5'}
				,{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(new _36_ValidSudoku().isValidSudoku(board));
	}

}
