package neetcode150.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/description/
// https://www.youtube.com/watch?v=TjFXEUCMqI8
// https://www.youtube.com/watch?v=Pl7mMcBm2b8
public class _8_36_ValidSudoku {

	public boolean isValidSudoku2(char[][] board) {
		Set<String> seen = new HashSet<String>();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				char number = board[i][j];
				if (number != '.')
					if (!seen.add(number + " in row " + i) || !seen.add(number + " in column " + j)
							|| !seen.add(number + " in block " + i / 3 + "-" + j / 3))
						return false;
			}
		}
		return true;
	}

	public boolean isValidSudoku3(char[][] board) {
		Map<Integer, Set<Character>> cols = new HashMap<>();
		Map<Integer, Set<Character>> rows = new HashMap<>();
		Map<String, Set<Character>> squares = new HashMap<>();

		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (board[r][c] == '.')
					continue;

				String squareKey = (r / 3) + "," + (c / 3);

				if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
						|| cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
						|| squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
					return false;
				}

				rows.get(r).add(board[r][c]);
				cols.get(c).add(board[r][c]);
				squares.get(squareKey).add(board[r][c]);
			}
		}
		return true;
	}

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

		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(new _8_36_ValidSudoku().isValidSudoku2(board));

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

		board = new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(new _8_36_ValidSudoku().isValidSudoku3(board));
	}

}
