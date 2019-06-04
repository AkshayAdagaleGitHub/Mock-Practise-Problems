/*
Question : Three number sum

Inputs : integer array, target k
output : triplets which sum to target k , A List

input: [12,3,1,2,-6,5,-8,6], 0
output: [[-8,2,6], [-8,3,5], [-6,1,5]]
                     
*/



import java.io.*;
import java.util.*;

class ThreeSum {

	public static void main (String[] args) {
		System.out.println("Hello Java");
    
    int[][] array = {null, // null
                       {}, // null
                       {12,3,1,2,-6,5,-8,6} // [[-8,2,6], [-8,3,5], [-6,1,5]]
                       };
    int[] target = {0, 0, 0};

    for(int i = 0; i < array.length; i++){
        System.out.println(triplets(array[i], target[i]));
    }

}

  public static List<List<Integer>>  triplets(int[] inputArray, int target){
      
      if(inputArray == null || inputArray.length == 0){
        return null;
      }

      List<List<Integer>> result = new ArrayList<>();
      Arrays.sort(inputArray);
      
      for(int n : inputArray){
         System.out.println(n);
      }

    // array = []
    for(int i = 0; i < inputArray.length - 2; i++){
      
      int current = inputArray[i];
      int l = i + 1;
      int r = inputArray.length - 1;
  
       while(l < r){
           int total = current + inputArray[l] + inputArray[r];
           
           if(total < target)
               l++;
           else if(total > target)
            r--;
          else if(total == target)
          {
            List<Integer> list1 = new ArrayList<>();
            list1.add(current);
            list1.add(inputArray[l]);
            list1.add(inputArray[r]);        
            result.add(list1);
            l++;
            r--;
         }
      }
    }
    return result;

  }

}
