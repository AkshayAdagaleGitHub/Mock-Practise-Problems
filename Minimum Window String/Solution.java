import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        System.out.println("Hello World");
        System.out.println(findSubstring("aaaaaaaaaabbbbbbbbccccccccsbabbbccc", "abc"));
        System.out.println(findSubstring("aaaaaaaaaabbc", "ac"));        
    }
    
    public static String findSubstring(String st1, String pattern){
        if(st1 == null || pattern == null || st1.length() < pattern.length()){
            return " ";
        }
        
        int len1 = st1.length();
        int len2 = pattern.length();
        
        int patternHash[] = new int[256];
        int st1Hash[] = new int[256];
        
        int count = 0;
        
        for(char a : pattern.toCharArray()){
            patternHash[a]++;
        }
        
        int startIndex = -1; int minLength = Integer.MAX_VALUE;
        int start = 0;
        
        for(int j = 0; j < len1; j++){
            char c = st1.charAt(j); 
            st1Hash[c]++;
                                        
            if(patternHash[c] != 0 && patternHash[c] == st1Hash[c]){
                count++;
            } 
            
            if(count == len2){
                while(start < j && st1Hash[st1.charAt(start)] > patternHash[st1.charAt(start)] || patternHash[st1.charAt(start)] == 0){
                    if(st1Hash[st1.charAt(start)] > patternHash[st1.charAt(start)])
                        st1Hash[st1.charAt(start)]--;
                  start++;
                }
                int winLength = j - start + 1;
                
                if(winLength < minLength){
                    minLength = winLength;
                    startIndex = start;
                }
            }
        }
        
        if(startIndex == -1){
            return " ";
        }
        
      return st1.substring(startIndex, startIndex + minLength);
    }
}
