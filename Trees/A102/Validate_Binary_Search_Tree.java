package Trees.A102;

import Trees.A101.Trees;
import Trees.TreeNode;

/*
 Question: https://leetcode.com/problems/validate-binary-search-tree/
* Given the root of a binary tree, determine if it is a valid binary search tree (BST).

* A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
* https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg
* Input: root = [2,1,3]
Output: true
* https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg
* Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
*
* */
public class Validate_Binary_Search_Tree {

    public static void main(String args[]){
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(1);
      root.right = new TreeNode(4);
      root.left.right = new TreeNode(2);
      System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        return false;
    }

    public static boolean isValid(TreeNode parent, Integer min, Integer max){
        if(parent == null){
            return true;
        }
       if(min != Integer.MIN_VALUE && parent.value < min){
           return false;
       }
       if(max != Integer.MAX_VALUE && parent.value > max){
           return false;
       }
        return isValid(parent.left, min, parent.value) && isValid(parent.right, parent.value, max);
    }

}
