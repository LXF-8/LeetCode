package dp;

/**
 * @author LXF
 * @date 2022/3/11
 */
public class MaxProfits {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else {
                maxProfit = Math.max(price - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfits maxProfits = new MaxProfits();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfits.maxProfit(prices));
        System.out.println(maxProfits.maxProfitSecond(prices));
    }

    /**
     * 第二次做 还是不太会
     */
    public int maxProfitSecond(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (Integer num : nums) {
            minPrice = Math.min(minPrice, num);
            maxProfit = Math.max(maxProfit, num - minPrice);
        }
        return maxProfit;
    }
}
