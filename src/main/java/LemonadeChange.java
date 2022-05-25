import java.util.HashMap;
import java.util.Map;

/**
 * @author LXF
 * @date 2022/1/27
 */
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) {
            return false;
        }
        if (bills[1] > 10) {
            return false;
        }
        Map<Integer, Integer> moneyMap = new HashMap<Integer, Integer>();
        int num5 = 0;
        int num10 = 0;
        moneyMap.put(5, num5);
        moneyMap.put(10, num10);
        for (int bill : bills) {
            if (bill == 5) {
                moneyMap.put(5, ++num5);
            } else if (bill == 10) {
                if (moneyMap.get(5) >= 1) {
                    moneyMap.put(5, --num5);
                    moneyMap.put(10, ++num10);
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (moneyMap.get(10) >= 1) {
                    if (moneyMap.get(5) >= 1) {
                        moneyMap.put(5, --num5);
                        moneyMap.put(10, --num10);
                        continue;
                    }
                }
                if (moneyMap.get(5) >= 3) {
                    num5 = num5 - 3;
                    moneyMap.put(5, num5);
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 5, 20, 20, 5, 5, 20, 5};
        boolean change = LemonadeChange.lemonadeChange(bills);
        System.out.println(change);
    }
}
