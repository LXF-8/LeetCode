package daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LXF
 * @date 2022/3/21
 */
public class FindTarget {

    private static Set<Integer> set = new HashSet<>();

    public static boolean findTarget(TreeNode root, int k) {

        if (set.contains(k - root.val)) {
            return true;
        }
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public static void bfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        bfs(root.left, set);
        bfs(root.right, set);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, null, new TreeNode(3));
        FindTarget.findTarget(root, 6);
    }

    // int[]数组维护每个index之前有几个char[0] char[1]
    // helper0[i] = helper0[i - 1] + text[i] == char[0] ? 1 : 0  helper1[i] = helper1[i - 1] + text[i] == char[1] ? 1 : 0
    // 中间遇到另一个数需要重置个数
    // char[0]尽量放前面 char[1]尽量放后面

    public void test(){
        String text = "iekbksdsmuuzwxbpmcngsfkjvpzuknqguzvzik";
        String m = "mp";
        // 找到text中每个p前面有几个m
        // == m ++ ==p count = 0
        //
    }
}

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

