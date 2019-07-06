
import java.io.*;
import java.util.*;

class Node {
     int value;
     Node left;
     Node right;

      public Node(int value){
          this.value = value;
          this.left = null;
          this.right = null;
      }
}
class LeafNodes {
	public static void main (String[] args) {
		System.out.println("Solution");
    
    Node root = new Node(1);

    root.left = new Node(2);
    root.right = new Node(3);
    
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    
    System.out.println(leafNodes(root));

	}

  public static List<List<Integer>> leafNodes(Node root){
      
      if(root == null){
          return new ArrayList<>();
      }

      List<List<Integer>> result = new ArrayList<>();
      getleafNodes(root, result);
      
      return result;
  }
  
  private static int getleafNodes(Node root, List<List<Integer>> result){
     
      if(root == null){
          return -1;
      }

      int level = 1 + Math.max(getleafNodes(root.left, result), getleafNodes(root.right,result));
      if(result.size() > level){
          result.get(level).add(root.value);
      }else{
        List<Integer> current = new ArrayList<>();
        current.add(root.value);
        result.add(current);
      }
      return level;
  }
  
}
