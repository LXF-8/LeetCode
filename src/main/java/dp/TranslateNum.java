package dp;

/**
 * @author LXF
 * @date 2022/3/11
 */
public class TranslateNum {

    public static int translateNum(int num) {
        // 从后往前
        // 小于6，前一位只能小于等于2且大于0
        // 大于6,前一位只能等于1
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return translateNum(num / 100) + translateNum(num / 10);
        } else {
            return translateNum(num / 10);
        }
    }

    public static void main(String[] args) {
        System.out.println(TranslateNum.translateNum(12258));
    }
}
