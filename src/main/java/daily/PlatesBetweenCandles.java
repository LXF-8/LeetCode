package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 蜡烛之间的盘子
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 * <p>
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 * <p>
 * 3 <= s.length <= 105
 * s 只包含字符 '*' 和 '|' 。
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= lefti <= righti < s.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plates-between-candles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plates-between-candles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LXF
 * @date 2022/3/8
 */
public class PlatesBetweenCandles {

    public int[] platesBetweenCandles2(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int n = chars.length, m = queries.length;
        // 每个位置最近的蜡烛下标
        int[] left = new int[n], right = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; i++, j--) {
            // 左边的蜡烛
            if (chars[i] == '|') {
                p = i;
            }
            // 右边的蜡烛
            if (chars[j] == '|') {
                q = j;
            }
            left[i] = p;
            right[j] = q;
            // 保存每个位置前面有几个盘子
            sum[i + 1] = sum[i] + (chars[i] == '*' ? 1 : 0);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int c = right[a], d = left[b];
            if (c != -1 && c <= d) {
                ans[i] = sum[d + 1] - sum[c];
            }
        }
        return ans;
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 找出所有的蜡烛
        // add: 并预处理出盘子的「前缀和」数组。
        char[] chars = s.toCharArray();

        int n = chars.length, m = queries.length;
        int[] ans = new int[m];
        int[] sum = new int[n + 1];

        // 用list存储所有蜡烛的下标
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '|') {
                list.add(i);
            }
            // 统计在此之前有几个盘子
            sum[i + 1] = sum[i] + (chars[i] == '*' ? 1 : 0);
        }

        // 数据中没有蜡烛，则没有在蜡烛中的数
        if (list.isEmpty()) {
            return ans;
        }

        for (int i = 0; i < m; i++) {
            int start = queries[i][0], end = queries[i][1];
            int c = -1, d = -1;
            // 找到start右边最近的蜡烛
            // 二分法查找  使用s中全部的蜡烛下标二分
            int left = 0, right = list.size() - 1;
            while (left < right) {
                int midd = (left + right) / 2;
                if (list.get(midd) >= start) {
                    right = midd;
                } else {
                    left = midd + 1;
                }
            }
            if (list.get(right) >= start) {
                // 离start右边最近的蜡烛
                c = list.get(right);
            } else {
                // 左边没蜡烛，缺少边界，肯定为0
                continue;
            }
            left = 0;
            right = list.size() - 1;
            while (left < right) {
                int midd = (left + right + 1) / 2;
                if (list.get(midd) <= end) {
                    left = midd;
                } else {
                    right = midd - 1;
                }
            }
            if (list.get(right) <= end) {
                d = list.get(right);
            } else {
                continue;
            }
            if (c <= d) {
                ans[i] = sum[d + 1] - sum[c];
            }
        }
        return ans;
    }
}
