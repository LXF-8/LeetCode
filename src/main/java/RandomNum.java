import java.util.*;

/**
 * @author LXF
 * @date 2022/1/19
 */
public class RandomNum {


    public static void main(String[] args) {
        int n = 35;
        Random rand1 = new Random();
        boolean[] flag = new boolean[n];
        int randInt = 0;
        for (int i = 0; i < 5; i++) {
            do {
                randInt = rand1.nextInt(n) + 1;
            } while (flag[randInt]);
            flag[randInt] = true;
            System.out.print(randInt + " ");
        }
    }

}
