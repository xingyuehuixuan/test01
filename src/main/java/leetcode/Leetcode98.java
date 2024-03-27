package leetcode;

import java.util.LinkedList;

public class Leetcode98 {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode node){
        if (node == null){
            return true;
        }
        boolean a = isValidBST2(node.left);
        if (!a){
            return false;
        }
        if (prev >= node.val){
            return false;
        }
        prev = node.val;
        boolean b = isValidBST2(node.right);
        return b;
    }
    public boolean isValidBST1(TreeNode node){
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE;
        while (p != null || !stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                p = p.left;
            }else {
                TreeNode pop = stack.pop();
                if (prev >= pop.val){
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }

    public boolean isValidBST3(TreeNode node){
        return doValid(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean doValid(TreeNode node, long min, long max){
        if (node == null){
            return true;
        }
        if (node.val <= min || node.val >= max){
            return false;
        }
        boolean a = doValid(node.left, min, node.val);
        boolean b = doValid(node.right, node.val, max);
        return a && b;
    }
}
