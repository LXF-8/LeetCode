package statck;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Stack;

/**
 * @author LXF
 * @date 2022/5/16
 */
public class Rain {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        // 将第一个值放入栈中
        stack.push(0);
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            // 取值但不弹出
            int stackPop = stack.peek();
            // 比栈顶元素小
            if (height[stackPop] > height[i]) {

            } else if (height[stackPop] == height[i]) {
                // 相等情况下，维护更右边的
                stack.pop();
            } else {
                int heightAtIndex = height[i];
                while (!stack.isEmpty() && heightAtIndex > height[stackPop]) {
                    int midd = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[midd];
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0) {
                            sum += hold;
                        }
                        stackPop = stack.peek();
                    }
                }
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        Rain rain = new Rain();
        rain.trap(height);
    }
}
