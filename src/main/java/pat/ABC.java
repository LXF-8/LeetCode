package pat;

import java.util.Scanner;

/**
 * 给定区间[-231, 231]内的3个整数A、B和C，请判断A+B是否大于C。
 * 输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。
 * 对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。
 * 4
 * 1 2 3
 * 2 3 4
 * 2147483647 0 2147483646
 * 0 -2147483648 -2147483647
 * @author LXF
 * @date 2022/1/18
 */
public class ABC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] a = new long[t];
        long[] b = new long[t];
        long[] c = new long[t];
        for (int i = 0; i < t; i++) {
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
            c[i] = sc.nextLong();
        }
        for (int i = 0; i < t; i++) {
            boolean result = c[i] - a[i] < b[i];
            int line = i + 1;
            System.out.println("Case #" + line + ": " + result);
        }
    }
}
