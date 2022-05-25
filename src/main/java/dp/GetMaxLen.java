package dp;

/**
 * @author LXF
 * @date 2022/3/15
 */
public class GetMaxLen {
    public static int getMaxLen(int[] nums) {
        int len = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;

        int maxLen = positive;
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                positive++;
                // 负数*正数仍然是负数
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                // 负数乘完变正数了
                int tempPositive = negative > 0 ? negative + 1 : 0;
                negative = positive + 1;
                // 多少个数的乘积为负数
                positive = tempPositive;
            } else {
                positive = 0;
                negative = 0;
            }
            maxLen = Math.max(maxLen, positive);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 7, 4};
        System.out.println(GetMaxLen.getMaxLen(nums));
    }
}
