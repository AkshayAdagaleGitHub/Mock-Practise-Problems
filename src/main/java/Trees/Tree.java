package Trees;

import Trees.A102.Level_Order_Traversal;

public class Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        operations(root);
    }

    public static void operations(TreeNode root){
        Level_Order_Traversal.levelOrderTraversals(root);
    }
}
