package UniquePaths2;
import java.util.*;

class Point{
	int row;
	int col;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
}
public class Unique_Paths_2 {

	public static void main(String[] args) {
		int[][] matrix = {
		                  {0,0,0},
		                  {0,1,0},
		                  {0,0,0}
						};
		
		int[][] matrix1 = {
                			{0,0,0},
                			{1,1,0},
                			{0,0,0}
				};
		int[][] matrix2 = {
    			{0,0,0},
    			{0,0,0},
    			{0,0,0}
	};
		
		int[][] matrix3 = {
    			{0,0,0},
    			{0,0,0},
    			{0,0,0},
    			{0,0,0},
    			{0,0,0},
    			{0,0,0},
    			{0,0,0}
	};
	   System.out.println(paths(matrix3));
	}

	public static int paths(int[][] matrix) {
		int path = 0;
		Set<Point> points = new HashSet<>();
		System.out.println(Arrays.deepToString(matrix));
		path = dfs(matrix, 0 , 0, points, 0);
		return path;
	}
	
	public static int dfs(int [][] matrix, int row, int col, Set<Point> points, int count) {
			Point p = new Point(row,col);
		if(row < 0 || col < 0 || row > matrix.length-1 || col > matrix[row].length-1  ) {
			points.remove(p);
			return 0;
		}
		if(points.contains(p) || matrix[row][col] == 1) {
			points.remove(p);	
			return 0;
		}
		if(row == matrix.length-1 && col == matrix[row].length-1 ) {
			return 1;
		}
		
		points.add(p);
		count = count + dfs(matrix, row, col + 1,points, count) + dfs(matrix, row + 1, col,points, count);
		points.remove(p);
		return count;
	}
}
