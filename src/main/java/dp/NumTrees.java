package dp;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * @author LXF
 * @date 2022/3/22
 */
public class NumTrees {

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        // dp[i]指总的情况有多少中
        // 每个数字都可以作为头节点，剩余的数字左树什么情况，右树什么情况
        // 需要满足搜索树
        // 0 左树个数  n - 1 右树个数
        // dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - 1; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
