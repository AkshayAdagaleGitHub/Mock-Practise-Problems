import java.io.*;
import java.util.*;

class Solution {
  /*[8, 10, 2]
  input:    arr = [8, 10, 2]
output: [20, 16, 80]
  
  arr = [8, 10, 2]
     20, 16, 80
    
     0   1  2   
     8, 10, 2
     
      0  1   2  
     64  180 40 
     
      0  1   2  
     64  180 40 
     
     [8, 10, 2]
     loop 0 to n
       arr[i] = product of all the other numbers
       
      TC -> O(n^2)
      SC -> O(1)
      0  1   2
      8, 10, 2
     
           0  1   2
input:     8, 10, 2
               ^
output:  [20, 16, 80] 

product: 20*8 = 160
result =  [ 1, 8, 80]
result    [20, 16, 80]
          ^
           
           int product: 1
           result := []int
           for i:n-1 to 0
                result[i] *= product
                product *= arr[i]
           }
           
  */
  static int[] arrayOfArrayProducts(int[] arr) {
    // your code goes here
    if(arr.length == 0 || arr.length == 1){
      return new int[]{};
    }
    int result[] = new int[arr.length];
    result[0] = 1;
    int product = 1;
    for(int i = 0; i < arr.length; i++){
       result[i] = product;
      product = product * arr[i];
    }
   product = 1;
    for(int i = arr.length-1; i >= 0; i--){
       result[i] = result[i] * product; 
      product = product * arr[i];
    }
    
    return result;
  }

  public static void main(String[] args) {
    int  arr[] = {8, 10, 2};
    System.out.println(Arrays.toString(arrayOfArrayProducts(arr)));
  }
/*
Test Case #1
Input:
[]
Expected:
[]
Actual:
[]

Test Case #2
Input:
[1]
Expected:
[]
Actual:
[]

Test Case #3
Input:
[2,2]
Expected:
[2,2]
Actual:
[2, 2]


Test Case #4
Input:
[2,7,3,4]
Expected:
[84,24,56,42]
Actual:
[84, 24, 56, 42]

Test Case #5
Input:
[2,3,0,982,10]
Expected:
[0,0,58920,0,0]
Actual:
[0, 0, 58920, 0, 0]


Test Case #6
Input:
[-3,17,430,-6,5,-12,-11,5]
Expected:
[-144738000,25542000,1009800,-72369000,86842800,-36184500,-39474000,86842800]
Actual:
[-144738000, 25542000, 1009800, -72369000, 86842800, -36184500, -39474000, 86842800]

*/
}
