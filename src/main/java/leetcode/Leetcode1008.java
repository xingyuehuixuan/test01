package leetcode;

public class Leetcode1008 {
    public TreeNode bstFromPreorder1(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            insert1(root, val);
        }
        return root;
    }

    private TreeNode insert1(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val < val) {
            node.right = insert1(node.right, val);
        } else if (node.val > val) {
            node.left = insert1(node.left, val);
        }
        return node;
    }

    int i = 0;

    public TreeNode bstFromPreorder2(int[] preorder) {
        return insert2(preorder, Integer.MAX_VALUE);
    }

    private TreeNode insert2(int[] preorder, int max) {
        if (i == preorder.length) {
            return null;
        }
        int val = preorder[0];
        if (val > max) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        i++;
        node.left = insert2(preorder, val);
        node.right = insert2(preorder, max);
        return node;
    }

    public TreeNode bstFromPreorder3(int[] preorder) {
        return partition(preorder, 0, preorder.length - 1);
    }

    private TreeNode partition(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while (index <= end) {
            if (preorder[index] > preorder[start]) {
                break;
            }
            index++;
        }
        root.left = partition(preorder, start + 1, index - 1);
        root.right = partition(preorder, index, end);
        return root;
    }
}
