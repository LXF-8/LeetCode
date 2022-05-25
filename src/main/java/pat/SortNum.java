package pat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 * <p>
 * <p>
 * <p>
 * A1 = 能被5整除的数字中所有偶数的和；
 * <p>
 * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 * <p>
 * A3 = 被5除后余2的数字的个数；
 * <p>
 * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
 * <p>
 * A5 = 被5除后余4的数字中最大数字。
 *
 * @author LXF
 * @date 2022/1/18
 */
public class SortNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        // 被5整除的偶数
        List<Integer> list1 = new ArrayList<>();
        // 被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
        List<Integer> list2 = new ArrayList<>();
        // 被5除后余2的数字的个数
        List<Integer> list3 = new ArrayList<>();
        // 被5除后余3的数字的平均数，精确到小数点后1位；
        List<Integer> list4 = new ArrayList<>();
        // 被5除后余4的数字中最大数字
        List<Integer> list5 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (num[i] % 5 == 0) {
                if (num[i] % 2 == 0) {
                    list1.add(num[i]);
                }
            } else if (num[i] % 5 == 1) {
                list2.add(num[i]);
            } else if (num[i] % 5 == 2) {
                list3.add(num[i]);
            } else if (num[i] % 5 == 3) {
                list4.add(num[i]);
            } else if (num[i] % 5 == 4) {
                list5.add(num[i]);
            }
        }
        int result1 = 0;
        for (Integer i : list1) {
            result1 += i;
        }
        String resultStr = list1.size() == 0 ? "N" : String.valueOf(result1);
        int result2 = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (i % 2 == 0) {
                result2 += list2.get(i);
            } else {
                result2 -= list2.get(i);
            }
        }
        String result2Str = list2.size() == 0 ? "N" : String.valueOf(result2);
        int result3 = list3.size();
        String result3Str = list3.size() == 0 ? "N" : String.valueOf(result3);
        int sum = 0;
        for (Integer i : list4) {
            sum += i;
        }
        double result4 = 0D;
        String result4Str = "N";
        if (list4.size() != 0) {
//            result4 = Math.round(sum * 10 / list4.size()) / 10;
            result4Str = String.format("%.1f", (sum * 1.0 / list4.size()));
        }
        int result5 = Integer.MIN_VALUE;
        for (Integer i : list5) {
            if (result5 < i) {
                result5 = i;
            }
        }
        String result5Str = list5.size() == 0 ? "N" : String.valueOf(result5);
        System.out.println(resultStr + " " + result2Str + " " + result3Str + " " + result4Str + " " + result5Str);
    }
}
