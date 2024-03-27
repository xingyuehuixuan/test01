package leetcode;

public class Leetcode701 {
    public TreeNode insetIntoBST(TreeNode node, int val){
        if (node == null){
            return new TreeNode(val);
        }
        if (val < node.val){
            node.left = insetIntoBST(node.left, val);
        } else if (val > node.val) {
            node.right = insetIntoBST(node.right, val);
        }
        return node;
    }
}
