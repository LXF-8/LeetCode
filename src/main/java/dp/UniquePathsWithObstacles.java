package dp;

/**
 * @author LXF
 * @date 2022/3/21
 */
public class UniquePathsWithObstacles {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] helper = new int[m][n];
//        helper[0][0] = 1;
        // 第一列
//        for (int i = 1; i < m; i++) {
//            if (obstacleGrid[i][0] == 1) {
//                helper[i][0] = 0;
//            } else if (helper[i - 1][0] == 0) {
//                helper[i][0] = 0;
//            } else {
//                helper[i][0] = 1;
//            }
//        }
        // obstacleGrid[i][0] == 1说明之后的都不能到达
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            helper[i][0] = 1;
        }
//        // 第一行
//        for (int j = 1; j < n; j++) {
//            if (obstacleGrid[0][j] == 1) {
//                helper[0][j] = 0;
//            } else if (helper[0][j - 1] == 0) {
//                helper[0][j] = 0;
//            } else {
//                helper[0][j] = 1;
//            }
//        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            helper[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                } else {
                    helper[i][j] = helper[i - 1][j] + helper[i][j - 1];
                }
            }
        }
        return helper[m - 1][n - 1];
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break; //一旦遇到障碍，后续都到不了
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break; ////一旦遇到障碍，后续都到不了
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0}
        };
        System.out.println(UniquePathsWithObstacles.uniquePathsWithObstacles2(obstacleGrid));
    }
}
