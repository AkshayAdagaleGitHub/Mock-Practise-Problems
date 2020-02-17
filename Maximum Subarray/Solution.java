   /*
   53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number)
 which has the largest sum and return its sum.
Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using 
the divide and conquer approach, which is more subtle.
   
Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4],
Output: 6

[-2, 1, -3, 4, -1, 2, 1, -5, 4]
                             i
                             j
    => -2 (maxSum)
       -1
        -1 + (-3) => -4
          -4 - (-2)  => -2 
        -2 (maxSum)
            -2+ (-3) => -5
                (-5) - (-3) => -2
  
  maxSum = -2    
      (-2+1) => -1
  maxSum = -1
    (-1 + -3) => -4
  currentSum = -4
              -4 - (-2) => -2
                 -2 - (1) => -3    
                       -3 - (-3) => 0
    maxSum = 0
              (-3 + 4) => 1
              maxSum = 1
                      1 - 1 => 0
                      0 -(-3) => 3
               maxSum = 3
                  3 + 2 => 5
              maxSum = 5
                 5 + 1 = 6
              maxSum = 6
              6 + (-5) => 1
                  1 - 4 => -3
                     -3 - -(1) => -2
                       -2 - 2 => -4
                          - 4 - 1 => -5
                            -5 - (-5) => 0
                                
                
*/  
     Solution 1(Worst)
    public static int maxSubArr(int array[]){
      if(array == null){
        return 0;
      }
      if(array.length == 1){
        return array[0];
      }
      int maxSum = array[0];
      int currSum = array[0];
      int j = 1;
     
      for(int i = 0; i < array.length; i++){
        while(j <= array.length-1 && (currSum + array[j]) > maxSum){
          maxSum = currSum + array[j];
          System.out.println("For Max Sum " + maxSum);
          j++;
        }
        if(j == array.length-1 && i == array.length-1){
              maxSum = Math.max(maxSum, array[j]);
              System.out.println("If");
            return maxSum;
        }
        while(currSum >= maxSum && i < j){
          currSum = currSum - array[i];
          i++;
        }
        if(i == array.length-1){
          maxSum = Math.max(maxSum, array[i]);
        }
      }
      return maxSum;
    }
    // Solution 2 (Best)
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int currSum = nums[0], maxSum = nums[0];

    for(int i = 1; i < n; ++i) {
      currSum = Math.max(nums[i], currSum + nums[i]);
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
