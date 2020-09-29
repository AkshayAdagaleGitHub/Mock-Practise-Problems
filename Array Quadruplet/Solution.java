import java.io.*;
import java.util.*;

class Solution {
 
  static int[] findArrayQuadruplet(int[] arr, int s) {
    // your code goes here
    Arrays.sort(arr);
    for(int i = 0; i <= arr.length - 3; i++){
      for(int j = i+1; j <= arr.length - 2; j++){
        int sum = arr[i]+ arr[j];
        int low = j+1;
        int high = arr.length-1;
        while(low < high){
          int add = sum + (arr[low] + arr[high]);
          if(add == s){
            return new int[]{arr[i], arr[j], arr[low], arr[high]};
          }
          if(add < s){ 
            low++; 
          }else {
            high--;
          }
        }
      }
    }
    return new int[]{};
  }

  public static void main(String[] args) { 

  }

}
/*
Test Case #1
Input:
[], 12
Expected:
[]
Actual:
[]

Test Case #2
Input:
[4,4,4], 12
Expected:
[]
Actual:
[]


Test Case #3
Input:
[4,4,4,2], 16
Expected:
[]
Actual:
[]

Test Case #4
Input:
[4,4,4,4], 16
Expected:
[4,4,4,4]
Actual:
[4, 4, 4, 4]

Test Case #5
Input:
[2,7,4,0,9,5,1,3], 20
Expected:
[0,4,7,9]
Actual:
[0, 4, 7, 9]

Test Case #6
Input:
[2,7,4,0,9,5,1,3], 120
Expected:
[]
Actual:
[]


Test Case #7
Input:
[1,2,3,4,5,9,19,12,12,19], 40
Expected:
[4,5,12,19]
Actual:
[4, 5, 12, 19]


*/
