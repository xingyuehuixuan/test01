package leetcode;

import java.util.LinkedList;

public class Leetcode938 {
    public int rangeSumBST1(TreeNode node, int low, int high) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.val > high) {
                    break;
                }
                if (pop.val >= low) {
                    sum += pop.val;
                }
                p = pop.right;
            }
        }
        return sum;
    }

    public int rangeSumBST2(TreeNode node, int low, int high) {
        if (node == null){
            return 0;
        }
        if (node.val > high) {
            return rangeSumBST2(node.left, low, high);
        }
        if (node.val < low) {
            return rangeSumBST2(node.right, low, high);
        }
        return node.val + rangeSumBST2(node.left, low, high) + rangeSumBST2(node.right, low, high);
    }
}
