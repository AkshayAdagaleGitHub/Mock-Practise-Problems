// This is not a working solution.This is just an apporach to solve it.
// You just need to create a new class node and then pass the head to the main function

public TraverseTree{

public static void main(String args[]){
  TreeNode node = root;  
  HashMap<Integer, List<Integer>> result = new HashMap<>();
  result.put(0, root.value);
  getTraverseLeft(node.left , result, 1);  
  getTraverseRight(node.right , result, 1);
}


public static void getTraverseLeft(TreeNode node , HashMap<Integer, List<Integer>> result, level){

      if(node == null){
        return;
      }

      if(result.get(level) == null){// 1 // 2
          result.put(level, new ArrayList<Integer>()); // 1 -> List  // 2 -> List // 3 -> List
      }

      result.get(level).add(node.value); // 1 -> 2 // 2 -> 5, 4 // 3 -> 11,10,9,8
      getTraverseLeft(node.right, result, level+1);
      getTraverseLeft(node.left, result, level+1);
}

public static void getTraverseRight(TreeNode node , HashMap<Integer, List<Integer>> result, level){

      if(node == null){
        return;
      }

      if(result.get(level) == null){
          result.put(level, new ArrayList<Integer>()); 
      }

      result.get(level).add(node.value); 
      getTraverseRight(node.left, result, level+1);
      getTraverseRight(node.right, result, level+1);
}

}
