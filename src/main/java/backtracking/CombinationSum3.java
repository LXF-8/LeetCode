package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 * <p>
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author LXF
 * @date 2022/3/8
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n < k) {
            return new ArrayList<>();
        }
        // 存储路径
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        // 当前的和
        int sum = 0;
        dfs(ans, path, 1, n, sum, k);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, Deque<Integer> path, int begin, int n, int sum, int k) {
        // 剪枝
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = begin; i <= 9 - (k - path.size()) + 1; i++) {
            path.addLast(i);
            sum += i;
            dfs(ans, path, i + 1, n, sum, k);
            path.removeLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combine = new CombinationSum3();
        int n = 7;
        int k = 3;
        List<List<Integer>> res = combine.combinationSum3(k, n);
        System.out.println(res);
    }
}
