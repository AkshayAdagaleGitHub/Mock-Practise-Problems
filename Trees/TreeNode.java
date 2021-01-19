package Trees;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
//      0 1 2 3 4 56
    // "3 y + 3 = 12" -> 3x = 12 - 3 => x = 9/3 => 3
//      toCharArray()
    //
    //   12
    //   =
    //   2
    //   +
    //   x         3
    //   3         9  (12 - 3 = 9) 9/3 => 3
    // Stack


    public TreeNode(int value){
        this.value = value;
    }

    TreeNode addNode(TreeNode root, int after, int value, String position){
        if(root == null){
            return root;
        }
        TreeNode current = root;
        while(current != null){
            if(current.value == after){
                if(position.equalsIgnoreCase("LEFT")){
                    current.left = new TreeNode(value);
                }else {
                    current.right = new TreeNode(value);
                }
                if(value > current.value){
                    current = current.right;
                }else{
                    current = current.left;
                }
            }
        }
        return root;
    }
}
