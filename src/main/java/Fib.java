/**
 * 斐波那契数列
 * @author LXF
 * @date 2022/1/27
 */
public class Fib {

    public int fib(int n) {
        // 自底向上
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int pre = 1, prepre = 0,sum = 0;
        for(int i = 2; i <= n; i++){
            // 当前数等于前两个数之和
            sum = pre + prepre;
            prepre = pre;
            pre = sum;
        }
        return sum;
    }
}
