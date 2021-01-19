package Trees.A101;

import Trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Traversal {
         // TC -> O(n)
        //  SC -> O(n)
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " -> ");
        inOrder(root.right);
    }

    // TC -> O(n)
    //  SC -> O(n)
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " -> ");
    }

    // TC -> O(n)
    //  SC -> O(n)
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.value + " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }
    /*
     *              5
     *            /    \
     *           3      7
     *         2  4    6  8
     * */
    //  TC -> O(n)
    //  SC -> O(n)
  public static void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);// =>       8 6 4 2  =>
      //  5
      //  3 7
      //  2 4 6 8
        while(!q.isEmpty()){
            TreeNode current = q.pop();

            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
            System.out.print(current.left.value + " " + current.right.value);
        }
  }
    /*
     *               5
     *           /       \
     *           3        7
     *         /  \     /  \
     *        2   4   6     8
     *                       C=null
     *    5
     *    4 -> 5
     *
     * 2345678
     * */

  public static void morrisInOrder(TreeNode root){
      if(root == null){
          return;
      }

      TreeNode current = root;
      while(current != null){
          if(current.left == null){
              System.out.print(current.value);
              current = current.right;
          }else {
              TreeNode predecessor = current.left;
              while(predecessor.right != null && predecessor.right != current ){
                  predecessor = predecessor.right;
              }
              if(predecessor.right == null){
                  predecessor.right = current;
                  current = current.left;
              }else {
                  System.out.print(current.value);
                  predecessor.right = null;
                  current = current.right;
              }
          }
      }

  }

}
