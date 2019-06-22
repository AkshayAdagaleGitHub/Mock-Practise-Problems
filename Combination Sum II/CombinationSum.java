
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		Arrays.sort(candidates);
		for(int n : candidates) {
			System.out.print(" "+n);
		}

		List<List<Integer>> result = new ArrayList<>();
		findCombinations(candidates, 0, 8, result, new ArrayList<Integer>());
		
		System.out.println("\n"+result);
	}


	public static void findCombinations(int[] candidates, int index ,int target, List<List<Integer>> result, List<Integer> combination ) {
		
		if(target == 0) {
			result.add(new ArrayList<Integer>(combination));
			return; 
		}
		
		if(target < 0) {
			return;
		}
		
		for(int i = index; i < candidates.length; i++) {
			if(i == index || candidates[i] != candidates[i-1]) {
				combination.add(candidates[i]);
				findCombinations(candidates, i+1, target - candidates[i], result, combination);
				combination.remove(combination.size() -1);
			}
		}
	}
}
