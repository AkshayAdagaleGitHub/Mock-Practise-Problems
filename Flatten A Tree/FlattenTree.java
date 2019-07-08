import java.io.*;

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

class MyCode {
	public static void main (String[] args) {
		System.out.println("Solution");
    
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(3);
    root.left.right = new Node(4);

    root.right = new Node(5);
    root.right.right = new Node(6);
    flattenTree(root);
    printTree(root);
 	}

    private static void printTree(Node root) {
      while(root != null) {
        System.out.print(" " + root.value);
        if (root.left != null) {
          System.out.println("Left present: " + root.left.value);
        }
        root = root.right;
      }
    }

    public static void flattenTree(Node root) {
      flattenTree(root, new Node[] {null});
    }

    private static void flattenTree(Node root, Node[] prev) {
      if (root == null)
         return;
      flattenTree(root.right, prev);
      flattenTree(root.left, prev);
      root.right = prev[0];
      root.left = null;
      prev[0] = root;
    }

    /*private static void flattenTree(Node root){
        if(root == null){
           return;
        }

        while(root.left != null){
            flattenTree(root.left);

            Node tempRight = root.right;
            root.right = root.left;
            root.left = null;
           
            Node temp = root.right;
            while(temp.right != null){
                temp = temp.right;
            }

          temp.right = tempRight;
        }
      flattenTree(root.right);
    }*/
 
}
