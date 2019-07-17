import java.util.*;
public class RatMaze {

	public static void main(String[] args) {

		int[][] matrix = { { 0, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, };
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> pair = new ArrayList<String>();

		getPath1(matrix, 0, 0, result, pair);
		System.out.println("Result " + result);
		System.out.println("Pairs " + pair);
	}

	public static void getPath1(int[][] matrix, int row, int col, List<List<String>> result, List<String> pair) {
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix.length) {
			return;
		}

		pair.add(row + "" + col);
		if (row == matrix.length - 1 && col == matrix[row].length - 1) {
			result.add(new ArrayList<String>(pair));
			return;
		}

		if (row >= matrix.length || col < 0 || col >= matrix.length || matrix[row][col] == 1) {
			pair.remove(pair.size() - 1);
			return;
		}

		getPath1(matrix, row, col + 1, result, pair);
		getPath1(matrix, row + 1, col, result, pair);
		pair.remove(pair.size() - 1);
	}

	public static boolean getPath(int[][] matrix, int row, int col, List<String> pair) {

		if (row > matrix.length - 1 || col > matrix.length - 1 || matrix[row][col] == 1) {
			return false;
		}

		boolean isAtDestination = (row == matrix.length - 1 && col == matrix.length - 1);

		if (isAtDestination || getPath(matrix, row + 1, col, pair) || getPath(matrix, row, col + 1, pair)) {
			pair.add(row + " " + col);
			return true;
		}
		return false;
	}
}
