import java.io.*;
import java.util.*;


class Solution {
  static class Point {
   int x;
   int y;
   int distance;
  
   Point(int x ,int y, int distance ){
     this.x = x;
     this.y = y;
     this.distance = distance;
   }
}
/*
grid = [[1, 1, 1, 1], [0, 0, 0, 1], [1, 1, 1, 1]]
sr = 0, sc = 0, tr = 2, tc = 0
output: 8
(The lines below represent this grid:)
     0 1 2 3 
 0   1 1 1 1
 1   0 0 0 1
 2   1 1 1 1
  
  (0,0) -> (2,0)
   
   shortestPath  
     currentPath
      if currentPath < shortestPath
           shortestPath

 queue<Points<i,j>>
   <0,>
   
  counter = 3
   
queue<Points<i,j>>
  <0,0>
  Set<Points<>> set 
  
  loop through queue till empty
    deque top
     travese its neighbours
      if non zero && !set.contains()
        enqueue
      
     count = count  + 1;

TC -> O(nxm)
SC -> O(nxm)

*/
  
  
	static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
		// your code goes here
  
     Queue<Point> q = new LinkedList<>();
     Set<Point> set = new HashSet<>();
    
     q.add(new Point(sr, sc, 0));
     set.add(new Point(sr, sc, 0));
     int [][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
     while(!q.isEmpty()){
       Point p = q.remove();
       int dist = p.distance;
       
       for(int r = 0; r < 4; r++){
           int row = p.x + d[r][0];
            int col = p.y + d[r][1];   
       if(row  >= 0 && col >= 0 && row <= grid.length-1 && col <= grid[0].length-1 && grid[row][col] == 1){
            q.add(new Point(row,col, dist+1));
            set.add(new Point(row,col, dist+1));
        }
         if(row == tr && col == tc){
            return dist+1;
         }
       }       
     }
      return -1;
  }

	public static void main(String[] args) {
	  int[][] grid = {{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}};
     int sr = 0, sc = 0, tr = 2, tc = 0;
    System.out.println(shortestCellPath(grid, sr, sc, tr, tc));
	}
}
