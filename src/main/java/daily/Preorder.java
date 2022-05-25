//package daily;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author LXF
// * @date 2022/3/10
// */
//public class Preorder {
//
//    public List<Integer> preorder(Node root) {
//        List<Integer> ans = new ArrayList<>();
//        pre(ans, root);
//        return ans;
//    }
//
//    public void pre(List<Integer> list, Node root) {
//        if (root == null) {
//            return;
//        }
//        list.add(root.val);
//        for (Node child : root.children) {
//            pre(list, child);
//        }
//    }
//
//
//}
//
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//}
