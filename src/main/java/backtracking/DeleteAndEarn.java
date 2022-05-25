package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LXF
 * @date 2022/3/11
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 统计每个数字的和
        List<Integer> sum = new ArrayList<>();
        sum.add(nums[0]);
        int size = 1;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                sum.set(size - 1, sum.get(size - 1) + nums[i]);
            } else if (nums[i] == nums[i - 1] + 1) {
                sum.add(nums[i]);
                size++;
            } else {
                ans += rob(sum);
                sum.clear();
                sum.add(nums[i]);
                size = 1;
            }
        }
        ans += rob(sum);
        return ans;
    }

    public int rob(List<Integer> sum) {
        int size = sum.size();
        if (size == 1) {
            return sum.get(0);
        }
        int first = sum.get(0), second = Math.max(sum.get(0), sum.get(1));
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + sum.get(i), second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 3, 3, 5};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        deleteAndEarn.deleteAndEarn(nums);
    }
}
