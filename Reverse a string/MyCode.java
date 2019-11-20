import java.io.*;
import java.util.*;


/*
  "hello my name is abc"
   i                    
  s = abc is  name my hello 
  
*/

class MyCode {
	public static void main (String[] args) {
		
    System.out.println("Solution");
    String s = "hello my name is abc";
    //-> abc is name my hello
    
    StringBuilder sb = new StringBuilder(s);
    sb.reverse();
    System.out.println(sb.toString());
    
    s = sb.toString();  
    String result = "";
    StringBuilder sb1 = new StringBuilder();
    
    for(int i = 0; i <= s.length() - 1; i++){
      if(s.charAt(i) != ' '){
           sb1.append(s.charAt(i));              
    } else {
        result =  result + sb1.reverse() + " ";
        sb1  = new StringBuilder();
    }
  }
    result = result + sb1.reverse();
    
    System.out.println(" Answer iterative ");
    System.out.println(result);
   
    s = "hello my name is abc";
    String[] words = s.split(" ");
    reverseStringRecursion(words, 0, words.length - 1);
    System.out.println(Arrays.toString(words));
}

/*
   Recursion 
   cba si eman ym olleh
   abc is name my hello
 
   abc dfg
   dfg abc  
*/

public static String reverseString(String s){
  if(s.length() == 0){
    return s;
  }
   return (reverseString(s.substring(1))) + s.charAt(0);
 }
 
 public static void reverseStringRecursion(String[] s, int left, int right){
  if(left == right){
    return;
  }

  String temp = s[left];
  s[left] = s[right];
  s[right] = temp;

  reverseStringRecursion(s, left+1, right-1);
 }
}
