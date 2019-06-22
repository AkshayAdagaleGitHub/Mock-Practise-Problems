```
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class ImageOverlap {

  enum DIRECTIONS {
     LEFT, RIGHT, UP, DOWN;
  };

	public static void main (String[] args) {
		System.out.println("Solution");
     /*int[][] A = {
                   {1}
                };
     int[][] B = {
                   {1}
                };*/

    /*int[][] A = {
                   {0}
                };
     int[][] B = {
                   {0}
                };*/

     /*int[][] A = {
                   {0}
                };
     int[][] B = {
                   {1}
                };*/
     /*int[][] A = {
                   {0,0},
                   {0,0}
                };
     int[][] B = {
                   {1,1},
                   {1,1}
                };*/

     /*int[][] A = {
                   {1,1},
                   {1,1}
                };
     int[][] B = {
                   {1,1},
                   {1,1}
                };*/

     /*int[][] A = {
                   {0,1},
                   {1,0}
                };
     int[][] B = {
                   {1,0},
                   {0,1}
                };*/

    int[][] A = { 
                  {1,1,0},
                  {0,1,0},
                  {0,1,0}
                  };
    int[][] B = {
                   {0,0,0},
                   {0,1,1},
                   {0,0,1}
                }; 

     System.out.println(largestOverlap( A, B));

	}



  //------------------
  public static int largestOverlap(int[][] A, int[][] B) {
    if (A == null || B == null || A.length != B.length || A[0].length != B[0].length || A.length != A[0].length)
       return -1;
    Map<String, Integer> cache = new HashMap<>();
    return largestOverlap(A, B, cache);
  }

  //------------------
  private static int largestOverlap(int[][] A, int[][] B, Map<String, Integer> cache ) {
    
    if (cache.containsKey(Arrays.deepToString(A))) 
       return cache.get(Arrays.deepToString(A));
    int match = matches(A, B);
    cache.put(Arrays.deepToString(A), match);
    //System.out.println(cache);
    for (DIRECTIONS direction : DIRECTIONS.values()) { 
        int[][] newMatrix = transform(A, direction);
        match = Math.max(match, largestOverlap(newMatrix, B, cache ));
    }
    return (match == Integer.MIN_VALUE) ? 0 : match;   
  }


  //-------------------
  private static int[][] transform(int[][] A, DIRECTIONS direction) {
    int[][] newMatrix = new int[A.length][A[0].length];
    switch(direction) {
      case LEFT:
         for (int row = 0; row < A.length; row++) 
             for (int col = 0; col < A[0].length; col++) 
                  newMatrix[row][col] = (col != A[0].length - 1) ? A[row][col + 1] : A[row][0];                   
         break;
      case RIGHT:
         for (int row = 0; row < A.length; row++) 
             for (int col = 0; col < A[0].length; col++) 
                  newMatrix[row][col] = (col != 0) ? A[row][col - 1] : A[row][A[0].length - 1];   
         break;
      case UP:
         for (int row = 0; row < A.length; row++) 
             for (int col = 0; col < A[0].length; col++) 
                  newMatrix[row][col] = (row != A.length - 1) ? A[row + 1][col] : A[0][col];  
         break;
      case DOWN:
          for (int row = 0; row < A.length; row++) 
             for (int col = 0; col < A[0].length; col++) 
                  newMatrix[row][col] = (row != 0) ? A[row - 1][col] : A[A.length - 1][col];  
         break;
    }
    return newMatrix;
  }

  //-----------------
  private static int matches(int[][] A, int[][] B) {
    int count = 0;
    for (int row = 0; row < A.length; row++) 
      for (int col = 0; col < A[0].length; col++) 
        if (A[row][col] == 1 && A[row][col] == B[row][col])
           count++;
    return count;
  }

}
