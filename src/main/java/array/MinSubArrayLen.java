package array;

/**
 * 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LXF
 * @date 2022/3/4
 */
public class MinSubArrayLen {

    // 滑动窗口法
    public static int minSubArrayLen(int target, int[] nums) {
        int minNum = Integer.MAX_VALUE;
        // 滑动窗口的起始位置
        int winStart = 0;
        // 滑动窗口的长度
        int winLen = 0;
        // 当前窗口的数值总和
        int winSum = 0;
        for (int i = 0; i < nums.length; i++) {
            winSum += nums[i];
            while (winSum >= target) {
                winLen = i - winStart + 1;
                minNum = Math.min(minNum, winLen);
                // 窗口向前滑动，窗口中的数值减少滑动的量
                winSum -= nums[winStart];
                winStart++;
            }
        }
        return minNum == Integer.MAX_VALUE ? 0 : minNum;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

}
