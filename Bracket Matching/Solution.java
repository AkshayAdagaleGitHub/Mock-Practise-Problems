import java.io.*;
import java.util.*;

class Solution {
  /*           
         counter
         ( 1
         ) 0
         ) -1 => output = 1, count = 0
         ( => 1
         
         output+count     
  */
  
  static int bracketMatch(String text) {
    int count = 0;
    int output = 0;
    
    for(char c  : text.toCharArray()){
          if(c == '('){
              count +=1;
          } else if(c == ')'){
              count -=1;
          }
        if(count < 0){
           count += 1;
          output += 1;
        }
      }
    return count+output;
  }

  public static void main(String[] args) {
           String[] text = {"(()" , "(())", "())("};
    
    for(String s : text){
       System.out.println(s + " " + bracketMatch(s));
    }
  }

}
