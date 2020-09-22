import java.io.*;
import java.util.*;

class Solution {

  static int deletionDistance(String str1, String str2) {
    // dog frog
    int[][] dp = new int[str1.length()+1][str2.length()+1];
   for(int row = 0; row <= str1.length(); row++){
    // System.out.println(row);
     dp[row][0] = row; 
    }

    for(int col = 0; col <= str2.length(); col++){
      dp[0][col] = col;
    }
    
    for(int row = 1; row < dp.length; row++){
      for(int col = 1; col < dp[0].length; col++){
        if(str1.charAt(row-1) == str2.charAt(col-1)){
           dp[row][col] = dp[row - 1][col - 1];
       } else if (str1.charAt(row-1) != str2.charAt(col-1)){
         dp[row][col]= Math.min(dp[row - 1][col], dp[row][col - 1]) + 1; 
        }  
      }
    }
    return dp[str1.length()][str2.length()];
  }

  public static void main(String[] args) {
    String str1 = "dog";
    String str2 = "frog";
    System.out.println(deletionDistance(str1, str2));
  }
/*
input:  str1 = "dog", str2 = "frog"
output: 3

   str1 = "dog", 
   str2 = "frog"
dp[][]
   0 1 2 3 4
  "" f r o g
"" 0 1 2 3 4 0
d  1 1 2 2 3 1
o  2 2 3 2 3 2   
g  3 3 4 3 3*3

Examples :
Examples:

input:  str1 = "dog", str2 = "frog"
output: 3

input:  str1 = "some", str2 = "some"
output: 0

input:  str1 = "some", str2 = "thing"
output: 9

input:  str1 = "", str2 = ""
output: 0

Test Case #1
Input: 
"", ""
Expected:
0
Actual:
0

Test Case #2
Input:
"", "hit"
Expected:
3
Actual:
3

Test Case #3
Input:
"neat", ""
Expected:
4
Actual:
4

Test Case #4
Input:
"heat", "hit"
Expected:
3
Actual:
3

Test Case #5
Input:
"hot", "not"
Expected:
2
Actual: 
2

Test Case #6
Input:
"some", "thing"
Expected:
9
Actual:
9

Test Case #7
Input:
"abc", "adbc"
Expected:
1
Actual:
1

Test Case #8
Input:
"awesome", "awesome"
Expected:
0
Actual:
0

Test Case #9
Input:
"ab", "ba"
Expected:
2
Actual:
2

*/
}
