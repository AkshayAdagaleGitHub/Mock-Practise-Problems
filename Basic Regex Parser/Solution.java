import java.io.*;
import java.util.*;

class Solution {
  
  static boolean isMatch(String text, String pattern) {
    char[] txt = text.toCharArray();
    char[] patt = pattern.toCharArray();
    boolean T[][] = new boolean[txt.length+1][patt.length+1];
    T[0][0] = true;
    for(int i = 1; i < T[0].length; i++){
      if(patt[i-1] == '*'){
        T[0][i] = T[0][i-2];
      }
    }
    
    for(int i = 1; i < T.length; i++){
      for(int j = 1; j < T[0].length; j++){
        if(patt[j-1] == '.' || patt[j-1] == txt[i-1]){
              T[i][j] = T[i-1][j-1];
        }else if (patt[j-1] == '*'){
            T[i][j] = T[i][j-2];
          if(patt[j-2] == '.' || patt[j-2] == txt[i-1]){
            T[i][j] = T[i][j] | T[i-1][j];
          }
        } else {
          T[i][j] = false;
        }
      }
    }
    return T[txt.length][patt.length];
  }

  public static void main(String[] args) {
      String text = "acd";
      String pattern = "ab*c";
      System.out.println(isMatch(text,pattern));
  }

}
