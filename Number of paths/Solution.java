import java.io.*;
import java.util.*;



class Solution {
 
  static int numOfPathsToDest(int n) {
    return paths(n,0,0);
  }
  
  public static int paths(int n, int x, int y){
    if(x > n || y > n){
        return 0;
      }

    if(x < y){
      return 0;
    }

    if(x == n-1 && y == n-1){
        return 1;
     }
    
    int ret = paths(n, x+1, y) + paths(n, x, y+1);
    return ret;
 }

  public static void main(String[] args) {
      int n = 4;
    System.out.println(numOfPathsToDest(n));
  }
  
/*
Test Case #1
Input:
1
Expected:
1
Actual:
1

Test Case #2
Input:
2
Expected:
1
Actual:
1

Test Case #3
Input:
3
Expected:
2
Actual:
2

Test Case #4
Input:
4
Expected:
5
Actual:
5

Test Case #5
Input:
6
Expected:
42
Actual:
42

Test Case #6
Input:
17
Expected:
35357670
Actual:
35357670

*/
}
