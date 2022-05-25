import java.util.LinkedList;
import java.util.Queue;

/**
 * 层级遍历
 *
 * @author LXF
 * @date 2022/1/17
 */
public class HierarchicalTraversal {

    public void node(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 将根节点加入到队列中
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {3,2,4,5,2,2,4,5};

    }
}
