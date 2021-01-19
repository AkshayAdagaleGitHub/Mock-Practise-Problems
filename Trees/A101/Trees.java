package Trees.A101;
import Trees.TreeNode;
/*
*              5
*            /    \
*           3      7
*         2  4    6  8
* */
public class Trees {
    public static void main(String args[]){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        // ******* DFS ********
        //        System.out.println("InOrder");
//        Traversal.inOrder(root);
//        System.out.println();
//        System.out.println("Post Order");
//        Traversal.postOrder(root);
//        System.out.println();
//        System.out.println("Pre Order");
//        Traversal.preOrder(root);
//    ********  BFS ******
//        System.out.println();
//        System.out.println("Level Order Traversal");
//        Traversal.levelOrderTraversal(root);
        Traversal.morrisInOrder(root);
    }
}
