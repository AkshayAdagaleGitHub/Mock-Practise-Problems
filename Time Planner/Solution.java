import java.io.*;
import java.util.*;

class Solution {
  static int[] meetingPlanner(int[][] slotA, int[][] slotB, int dur) {
    int i = 0;
    int j = 0;
    int maxStart = 0;
    int minEnd = 0;

   while((i < slotA.length) && (j < slotB.length)){
      if(slotB[j][0] < slotA[i][1]){
        maxStart = Math.max(slotB[j][0],slotA[i][0]);
        minEnd = Math.min(slotB[j][1],slotA[i][1]);
        if((minEnd - maxStart) >= dur){
          minEnd = maxStart + dur;
          return new int[]{maxStart, minEnd};
        }else if(slotA[i][1] < slotB[j][1]){
          i++;
        } else {
          j++;
        }
      } else {
        i++;
      }
    }
  return new int[]{};
  }

  public static void main(String[] args) {
  int[][] slotsA = new int[][]{{10, 50}, {60, 120}, {140, 210}};
  int[][] slotsB = new int[][]{{0, 15}, {60, 70}};
  int dur = 8;
   System.out.println( Arrays.toString(meetingPlanner(slotsA, slotsB, dur)));
  }
  
 /*
  
Test Cases :
     
Test Case #1
Input:
[[7,12]], [[2,11]], 5
Expected:
[]
Actual: 
[]

Test Case #2
Input:
[[6,12]], [[2,11]], 5
Expected:
[6,11]
Actual: 
[6, 11]

Test Case #3
Input:
[[1,10]], [[2,3],[5,7]], 2
Expected:
[5,7]
Actual:
[5, 7]

Test Case #4
Input:
[[0,5],[50,70],[120,125]], [[0,50]], 8
Expected: 
[]
Actual:
[]

Test Case #5
Input:
[[10,50],[60,120],[140,210]], [[0,15],[60,70]], 8
Expected:
[60,68]
Actual:
[60, 68]

Test Case #6
Input:
[[10,50],[60,120],[140,210]], [[0,15],[60,72]], 12
Expected:
[60,72]
Actual:
[60, 72]
 
 */

}
