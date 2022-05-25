package array;

/**
 * 移动零
 *
 * @author LXF
 * @date 2022/3/4
 */
public class RemoveZero {

    public static void removeZero(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
    }
}
