package Trees.A101;
import Trees.TreeNode;


public class MorrisTraversal {

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(-2);
        root.left.left.right = new TreeNode(2);
        root.left.left.right.left = new TreeNode(-1);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(30);
        root.right.right = new TreeNode(40);
    }

    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                System.out.println(current.value);
                current = current.right;
            }else{
                TreeNode predecessor = current;
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else{
                    predecessor.right = null;
                    System.out.println(current.value);
                    current = current.right;
                }
            }
        }
    }

}
