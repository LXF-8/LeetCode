/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * <p>
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 * <p>
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LXF
 * @date 2022/3/9
 */
public class CorpFlightBookings {

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int[] temp = new int[n + 1];
        for (int i = 0; i < bookings.length; i++) {
            int left = bookings[i][0] - 1;
            int right = bookings[i][1] - 1;
            int value = bookings[i][2];
            temp[left] += value;
            temp[right + 1] -= value;
        }
        ans[0] = temp[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + temp[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 10}, {2, 3, 20}, {2, 5, 25}
        };
        corpFlightBookings(nums, 5);
    }

}
