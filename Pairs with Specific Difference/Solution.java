import java.io.*;
import java.util.*;

/*
  arr = [0, -1, -2, 2, 1], k = 1
  
  
output: [[1, 0],[ 0, -1],[-1, -2],[2, 1]]

 0   1   2  3  4
 0, -1, -2, 2, 1 
 x
            
    Map<Integer, Integer> map  candidate y => already found x
    
     -1 -> 0
     -2 -> -1
     -3 -> -2
      1 -> 2
      0 -> 1
      
      [1,0] [0,-1] [-1, -2] [2, 1]
  
*/
class Solution {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    // your code goes here
    if(k == 0){
      return new int[0][0];
    }
    
    Map<Integer, Integer> result = new HashMap<>();
    for(int x = 0; x < arr.length; x++){
      result.put(arr[x] - k, arr[x]);
    }

    List<int[]> l = new ArrayList<>();
    for(int y = 0; y < arr.length; y++){
      if(result.containsKey(arr[y])){
        l.add(new int[]{result.get(arr[y]), arr[y]});  
      }
    }

    int res[][] = new int[l.size()][2];
    for(int i = 0; i < l.size(); i++ ){
      res[i][0] = l.get(i)[0];
      res[i][1] = l.get(i)[1];
    }
    return res;
  }

  public static void main(String[] args) {
     //int[] arr = {0, -1, -2, 2, 1};
    int[] arr = {4, 1}; 
    int k = 3;
    System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr, k)));
  }
/*
Test Case #1
Input:
[4,1], 3
Expected:
[[4,1]]
Actual:
[[4, 1]]


Test Case #2
Input:
[1,5,11,7], 4
Expected: 
[[5,1],[11,7]]
Actual:
[[5, 1], [11, 7]]

Test Case #3
Input:
[1,5,11,7], 6
Expected:
[[7,1],[11,5]]
Actual:
[[7, 1], [11, 5]]



Test Case #4
Input:
[1,5,11,7], 10
Expected:
[[11,1]]
Actual:
[[11, 1]]

Test Case #5
Input:
[0,-1,-2,2,1], 1
Expected:
[[1,0],[0,-1],[-1,-2],[2,1]]
Actual:
[[1, 0], [0, -1], [-1, -2], [2, 1]]


Test Case #6
Input:
[1,7,5,3,32,17,12], 17
Expected:
[]
Actual:
[]

*/
}
