package statck;

import java.util.Stack;

/**
 * @author LXF
 * @date 2022/5/16
 */
public class DailyTemperature {

//    输入: temperatures = [73,74,75,71,69,72,76,73]
//    输出: [1,1,4,2,1,1,0,0]

    public int[] dailyTemperatur(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperature = dailyTemperature.dailyTemperatur(temperatures);
        System.out.println(temperature);
    }
}
