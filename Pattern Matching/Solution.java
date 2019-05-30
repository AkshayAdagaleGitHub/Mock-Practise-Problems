import java.io.*;

class Solution {
	public static void main (String[] args) {
		System.out.println("Hello Java");
    String inputString = "acdcb";
    String pattern = "a*c?b";
    System.out.println("Result is " + patternMatching(inputString, pattern));
	}

  public static boolean patternMatching(String inputString, String pattern){

      if(inputString == null || pattern == null){
          return false;
      }
        boolean result[][] = new boolean[pattern.length()+1][inputString.length()+1];

        result[0][0] = true;

        // Mark true or false for empty 
        for(int i = 1; i <= inputString.length(); i++ ){
              result[0][i] = false; 
        }

        // Column
        for(int i = 1; i <= pattern.length(); i++ ){
             if(pattern.charAt(i-1) == '*')
              {
                   result[i][0] = result[0][i-1];
              }else{
                result[i][0] = false; 
              }
        }
   
        for(int i = 1; i <= pattern.length(); i++){
            for(int j = 1; j <= inputString.length(); j++){
                  if(pattern.charAt(i-1) == '*'){
                      result[i][j] = result[i][j-1] || result[i-1][j];
                  }else if(pattern.charAt(i-1) == '?' || 
                      pattern.charAt(i-1) == inputString.charAt(j-1)){
                          result[i][j] = result[i-1][j-1];
                  }
                  else{
                    result[i][j] = false;
                  }
              }
          }
      return result[pattern.length()][inputString.length()];
    }

}
