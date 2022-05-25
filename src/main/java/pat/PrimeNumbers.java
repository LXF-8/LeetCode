package pat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LXF
 * @date 2022/1/18
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int[] prime = new int[10000];
        int sort = 0;
        for (int i = 2; i < 1000000; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prime[sort] = i;
                sort++;
                if (sort == 10000){
                    break;
                }
            }
        }
        int fa = 1;
        for (int i = min - 1; i < max; i++) {
            if (fa < 10) {
                System.out.print(prime[i] + " ");
                fa++;
            } else {
                System.out.println(prime[i]);
                fa = 1;
            }
        }
    }
}
