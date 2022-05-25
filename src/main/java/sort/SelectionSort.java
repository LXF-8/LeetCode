package sort;

/**
 * @author LXF
 * @date 2022/2/28
 */
public class SelectionSort {

    public static void selectionSort(int[] nums) {
        // perf 可以做个容量判断，length < 2的就没必要排序
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 最大值的下标
            int maxIndex = i;
            // error 要从+1开始 for (int j = i; j < nums.length; j++)
            for (int j = i + 1; j < nums.length; j++) {
                maxIndex = nums[i] > nums[j] ? i : j;
            }
            swap(nums, i, maxIndex);
        }
    }

    /**
     * 交换值
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
