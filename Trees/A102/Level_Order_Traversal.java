package Trees.A102;

import Trees.TreeNode;

import java.util.*;

public class Level_Order_Traversal {
    //Recursion
    public static void levelOrderTraversals(TreeNode root){
         if(root == null){
             return;
         }
         Map<Integer, List<Integer>> levels = new HashMap<>();
         System.out.println(" Recursion ");
         levelOrderTraversalRecursion(root,levels, 0);
         System.out.println(levels);
         System.out.println(" Queue ");
        levelOrderTraversalQueue(root);
     }

     public static void levelOrderTraversalRecursion(TreeNode root, Map<Integer, List<Integer>> levels, int level){
        if(root == null){
            return;
        }
        if(!levels.containsKey(level)){
            levels.put(level, new ArrayList<Integer>());
        }
        levels.get(level).add(root.value);
        levelOrderTraversalRecursion(root.left,levels,level+1);
        levelOrderTraversalRecursion(root.right,levels,level+1);
     }
    /*
     *              5
     *            /    \
     *           3      7
     *         2  4    6  8
     * */
    public static void levelOrderTraversalQueue(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode level = null;
        q.add(level);

//        List<Integer> levels = new ArrayList<Integer>();
        // q =>     null
        // [5]  [3,7] [2,4,6,8]
        // print level

        while(q.size() > 1){
            TreeNode current = q.pop();
            if(current == null){
                System.out.println();
                q.add(current);
            } else {
                System.out.print(" "+current.value);
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
        }
    }

}
