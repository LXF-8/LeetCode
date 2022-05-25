package dp;

/**
 * 正数拆分
 *
 * @author LXF
 * @date 2022/3/22
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        // 不能拆分为两个正整数
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // 1 * 1 dp[3] =Math.max( 1 * dp[2] , 2 * dp[1])
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // dp[i]:记录此次j的最大值  j * (i - j) 拆分为两数  j * dp[i - j]至少为3个数
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
