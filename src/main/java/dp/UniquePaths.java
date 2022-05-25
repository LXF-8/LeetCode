package dp;

/**
 * @author LXF
 * @date 2022/3/21
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] helper = new int[m][n];
        for (int j = 0; j < n; j++) {
            helper[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            helper[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                helper[i][j] = helper[i - 1][j] + helper[i][j - 1];
            }
        }
        return helper[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(UniquePaths.uniquePaths(2, 3));
    }
}
