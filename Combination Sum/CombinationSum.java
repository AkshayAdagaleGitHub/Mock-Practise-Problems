import java.io.*;
import java.util.List;
import java.util.ArrayList;

class MyCode {
	public static void main (String[] args) {
		System.out.println("Hello Java");
    int[] candidates = {2,3,6,7};
    int target = 7;
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      result = combinations(candidates, target);
      System.out.println(result);
  }

  public static List<List<Integer>> combinations(int[] candidates, int target){
    
    if(candidates == null || candidates.length == 0){
        return new ArrayList<List<Integer>>();
    }
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      combinations(candidates, 0, 7, new ArrayList<Integer>(), result);
      return result;
  }

  public static void combinations(int[] candidates,int index, int target, List<Integer> candidateSubArray, List<List<Integer>> result){

    if(target == 0){
      result.add(new ArrayList<>(candidateSubArray));
      return;
    }
    
    if(target < 0){
      return;
    }
      
      for(int i = index; i < candidates.length; i++){     
          //System.out.println("Current i is " + i + " Candidate Value is " + candidates[i]); 
          candidateSubArray.add(candidates[i]);
          combinations(candidates, i, target - candidates[i] , candidateSubArray, result);
          candidateSubArray.remove(candidateSubArray.size() - 1); 
      }
    }
 }
