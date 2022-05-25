import java.util.PriorityQueue;

/**
 * @author LXF
 * @date 2022/2/7
 */
public class LongestDiverseString {

    public static String longestDiverseString(int a, int b, int c) {
        // 创建优先级队列 降序排列
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) {
            priorityQueue.add(new int[]{0, a});
        }
        if (b > 0) {
            priorityQueue.add(new int[]{1, b});
        }
        if (c > 0) {
            priorityQueue.add(new int[]{2, c});
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            int n = sb.length();
            // 前面已经有两个数了
            if (n >= 2 && sb.charAt(n - 1) - 'a' == cur[0] && sb.charAt(n - 2) - 'a' == cur[0]) {
                if (priorityQueue.isEmpty()) {
                    break;
                }
                int[] next = priorityQueue.poll();
                sb.append((char) (next[0] + 'a'));
                // next中的数被使用了，数量要减1
                next[1]--;
                if (next[1] != 0) {
                    priorityQueue.add(next);
                }
                priorityQueue.add(cur);
            } else {
                sb.append((char) (cur[0] + 'a'));
                cur[1]--;
                if (cur[1] != 0) {
                    priorityQueue.add(cur);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String result = LongestDiverseString.longestDiverseString(7, 1, 0);
        System.out.println(result);
    }


}
