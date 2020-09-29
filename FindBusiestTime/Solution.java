import java.io.*;
import java.util.*;

class Solution {
  static int findBusiestPeriod(int[][] data) {
    // your code goes here
      int maxTime = data[0][0];
      int currTime = 0;
      int prevTime = 0;
      int i = 0;
      int count = 0;
      int maxCount = Integer.MIN_VALUE;

    while(i < data.length){
      if(prevTime != data[i][0]){
        if(count > maxCount){//8
          maxTime = prevTime;//425
          maxCount = count; //
        }
      }
      currTime = data[i][0];//378
     
      if(data[i][2] == 1){
        count = count + data[i][1];//14
      }else if(data[i][2] == 0){
        count = count - data[i][1]; //10 // 8
      }
      
      prevTime = data[i][0];
      i++;
    }
    
     if(count > maxCount){//8
        maxTime = prevTime;//425
        maxCount = count; //
      }
      
    return maxTime;
  }

  public static void main(String[] args) {
    int[][]  data = {{1487799425, 14, 1}, 
                   {1487799425, 4,  0},
                   {1487799425, 2,  0},
                   {1487800378, 10, 1},
                   {1487801478, 18, 0},
                   {1487801478, 18, 1},
                   {1487901013, 1,  0},
                   {1487901211, 7,  1},
                   {1487901211, 7,  0}};
  System.out.println(findBusiestPeriod(data));
  
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
