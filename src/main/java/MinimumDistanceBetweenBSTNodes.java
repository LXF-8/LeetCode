/**
 * @author LXF
 * @date 2021/12/10
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(27);
        TreeNode right1 = new TreeNode(34);
        root.right = right1;
        TreeNode right2 = new TreeNode(58);
        right1.right = right2;
        TreeNode left3 = new TreeNode(50);
        right2.left = left3;
        TreeNode left4 = new TreeNode(44);
        left3.left = left4;
        System.out.println(Solution.minDiffInBST(root));
    }
}

class Solution {

    private static int num = Integer.MAX_VALUE;

    public static int minDiffInBST(TreeNode root) {
        transf(root);
        return num;
    }


    public static void transf(TreeNode node) {
        if (node != null) {
            transf(node.left);
            if (node.left != null) {
                int temp = Math.abs(node.left.val - node.val);
                num = Math.min(num, temp);
            }
            if (node.right != null) {
                int temp = Math.abs(node.right.val - node.val);
                num = Math.min(num, temp);
            }
            transf(node.right);
        }
        return;
    }
}
