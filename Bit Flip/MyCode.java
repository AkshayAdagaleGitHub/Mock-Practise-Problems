```
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Result {
  List<String> list = new ArrayList<>();
  boolean flag = false;

  public Result(boolean flag){
    this.flag = flag;
  }

}

class MyCode {
	public static void main (String[] args) {
		System.out.println("Hello Java"); 
    Set<String> visited = new HashSet<>();
    visited.add("00");
    Result r = combination("00", "11", visited);
    if (r.flag) r.list.add("00");
    System.out.println(r.list);
	//permutation("01","");
  }

  public static String flipAtI(String input, int i) {
      if (i < 0 || i >= input.length()) {
        return null;
      }
      char c = input.charAt(i);
      String newString = "";
      if (c == '0') {
         if (i != input.length() - 1)
            newString = input.substring(0, i) + '1' + input.substring(i + 1);
         else
            newString = input.substring(0, i) + '1';
      }   
      else {
         if (i != input.length() - 1)
            newString = input.substring(0, i) + '0' + input.substring(i + 1);
        else 
            newString = input.substring(0, i) + '0';
      }
      return newString;
  }

  public static Result combination(String start, String end, Set<String> visited) {   
    if (start == null || end == null)
       return new Result(false);
    if(start.equals(end))
        return new Result(true);
  
    for (int i = 0; i < start.length(); i++) {
      char c = start.charAt(i);
      String newString = flipAtI(start, i);
      if (visited.contains(newString))
          continue;
      visited.add(newString);
      Result r = combination(newString, end, visited);
      if (r.flag) {
        r.list.add(newString);
        return r;
      }
    }
    return new Result(false);     
  }
}
```
