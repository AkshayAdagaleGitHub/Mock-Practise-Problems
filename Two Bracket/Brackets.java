'''
import java.io.*;
import java.util.*;

class Brackets {
	public static void main (String[] args) {
		System.out.println("Hello Java");
    List<String> input = new ArrayList<>();
    //input.add(null);
    //input.add("{}");
    //input.add("{");
    //input.add("{[]}");
    //input.add("{[()]}");
    input.add("{[(])}");
    //input.add("{[()]}");
    isBalanced(input);
	}

  public static List<String> isBalanced(List<String> parentheses){
      if(parentheses == null){
          return new ArrayList<String>();
      }
      List<String> result = new ArrayList<>();
      boolean check = true;
      for(String parenthesis : parentheses){
          int length = parenthesis.length() - 1;
          Stack<Character> stack = new Stack<>();
          while(length >= 0){
              char c = parenthesis.charAt(length);
              if(c == '('){
                if(stack.size() != 0){
                  char p = stack.pop();
                  if(p != ')'){
                      result.add("NO");
                      check = false;
                      break;
                  }
                }else{
                   result.add("NO");
                   check = false;
                   break;
                }
              }else if(c == '{'){
                if(stack.size() != 0){
                  char p = stack.pop();
                  if(p != '}'){
                      result.add("NO");
                  check = false;
                  break;
                  }
                }else{
                   result.add("NO");
                check = false;
                break;
                }
              }else if(c == '['){
                if(stack.size() != 0){
                  char p = stack.pop();
                  if(p != ']'){
                      result.add("NO");
                  check = false;
                  break;
                  }
                }else{
                   result.add("NO");
                check = false;
                break;
                }
              }else{
                stack.add(c);
              }
              length--;
          }
          if(check && stack.size() == 0){
            result.add("YES");
          }
      }
      for(String s : result){
        System.out.println(s);
      }
      return result;
  } 
}

'''
