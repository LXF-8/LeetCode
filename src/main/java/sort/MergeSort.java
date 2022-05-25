package sort;

/**
 * 归并排序
 * @author LXF
 * @date 2022/3/21
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    public void process(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int midd = left + ((right - left) >> 1);
        process(nums, left, midd);
        process(nums, midd + 1, right);
        merge(nums, left, midd, right);
    }

    public void merge(int[] nums, int left, int midd, int right) {
        int[] helper = new int[right - left + 1];
        int p1 = left;
        int p2 = midd + 1;
        int i = 0;
        while (p1 <= midd && p2 <= right) {
            helper[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        if (p1 <= midd) {
            helper[i++] = nums[p1++];
        }
        if (p2 <= right) {
            helper[i++] = nums[p2++];
        }
        for (i = 0; i < helper.length; i++) {
            nums[left + i] = helper[i];
        }
    }
}
