/*
Test Case #1
Input: [1], 0
Expected: [1]
Actual: [1]

Test Case #2
Input: [1,0], 1
Expected: [0,1]
Actual: [0, 1]

Test Case #3
Input: [1,0,3,2], 1
Expected: [0,1,2,3]
Actual: [0, 1, 2, 3]

Test Case #4
Input: [1,0,3,2,4,5,7,6,8], 1
Expected: [0,1,2,3,4,5,6,7,8]
Actual: [0, 1, 2, 3, 4, 5, 6, 7, 8]

Test Case #5
Input: [1,4,5,2,3,7,8,6,10,9], 2
Expected: [1,2,3,4,5,6,7,8,9,10]
Actual: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Test Case #6
Input: [6,1,4,11,2,0,3,7,10,5,8,9], 6
Expected: [0,1,2,3,4,5,6,7,8,9,10,11]
Actual: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

*/

import java.io.*;
import java.util.*;

class KMessedArray {

  static int[] sortKMessedArray(int[] arr, int k) {
    if(arr == null ){
      return arr;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0; i <= k; i++){
      pq.add(arr[i]);
    }
    
   for(int i = k+1;  i < arr.length; i++){
          arr[i-(k+1)] = pq.remove();
          pq.add(arr[i]); 
   }
    for(int i = 0; i <= k; i++){
      arr[(arr.length-k-1) + i] = pq.remove();
    }
    
    return arr;
  }
  
  public static void main(String[] args) {
    int arr[] = new int[] {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
    int k = 2;
    int[] result=sortKMessedArray(arr, k);
    System.out.println("length: "+result.length);
    //System.out.println(Arrays.toString(sortKMessedArray(arr, k)));
  }
}
