package dp;

/**
 * @author LXF
 * @date 2022/3/16
 */
public class MaxScoreSightseeingPair {

    public static int maxScoreSightseeingPair1(int[] nums) {
        int maxScore = Integer.MIN_VALUE;
        // 暴力
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int score = nums[i] + nums[j] + i - j;
                maxScore = Math.max(score, maxScore);
            }
        }
        return maxScore;
    }

    public static int maxScoreSightseeingPair2(int[] nums) {
        int maxI = nums[0] + 0;
        int ans = 0;
        // nums[i] + nums[j] + i - j = nums[i] + i + nums[j] - j
        for (int j = 1; j < nums.length; j++) {
            ans = Math.max(ans, maxI + nums[j] - j);
            maxI = Math.max(maxI, nums[j] + j);
        }
        return ans;
    }

    public static int[] generateArrays(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 5, 2, 6};

        for (int i = 0; i < 10000; i++) {
            int maxSize = 50000;
            int maxValue = 1000;
            int[] arrays = MaxScoreSightseeingPair.generateArrays(maxSize, maxValue);
            if (maxScoreSightseeingPair1(arrays) != maxScoreSightseeingPair2(arrays)){
                System.out.println("eeeeee");
            }
        }
    }
}
