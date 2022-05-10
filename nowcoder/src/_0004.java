import java.util.Scanner;

/**
 * 题目描述：
 * 一天一只顽猴想要从山脚爬到山顶
 * 途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
 * 试问？猴子通过这个阶梯有多少种不同的跳跃方式
 * <p>
 * 输入描述
 * 输入只有一个这个数n 0 < n < 50
 * 此阶梯有多个台阶
 * <p>
 * 输出描述
 * 有多少种跳跃方式
 * <p>
 * 示例一
 * 输入
 * <p>
 * 50
 * COPY
 * 输出
 * <p>
 * 122106097
 * COPY
 * 示例二
 * 输入
 * <p>
 * 3
 * COPY
 * 输出
 * <p>
 * 2
 * COPY
 */
public class _0004 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(solution1(n));
            System.out.println(solution2(n));
        }
    }

    /**
     * 动态规划
     *
     * @param n n
     */
    private static int solution2(int n) {
        //第1级台阶， 1种方式
        int step1 = 1;
        //第2级台阶2=1+1，1种方式
        int step2 = 1;
        //第3级台阶3=1+1+1或3，2种方式
        int step3 = 2;
        //第n级台阶， 初始值，如果n是1或者2，就返回1种方式，如果是3，就返回2种方式
        int step4 = n == 1 || n == 2 ? 1 : 2;
        for (int i = 4; i <= n; i++) {
            //如果n = 4, 那么它之前在哪一阶， 两种情况f(1) 或f(3)级,要么就是一次走3步，要么就是一次走1步， 累加就是总的情况
            step4 = step3 + step1;
            step1 = step2;
            step2 = step3;
            step3 = step4;
        }
        return step4;
    }


    /**
     * 1）、探求f（k）的递推关系；
     * <p>
     * 假设：k=100;
     * <p>
     * 上山最后一步到达第100级台阶，完成上山，共有f（100）种不同的爬法，到第100级之前位于哪一级呢？无非是位于第99级（上跳1级即到），有f（99）种；
     * <p>
     * 或位于第97级（上跳3级即到），有f（97）种，于是，两种情况累加就是总的情况数：
     * <p>
     * f（100）=f（99）+f（97）
     * f（99）= f（98）+f（96）
     * f（97）= f（96）+f（94）
     * 依次类推
     * 以此类推，一般地有递推关系：
     * <p>
     * f（k）=f（k-1）+f（k-3） （k>3）
     * （2）、确定初始条件：
     * <p>
     * f（1）=1，即1=1；
     * <p>
     * f（2）=1，即2=1+1（注意：跳法中不允许直接跳2级）；
     * <p>
     * f（3）=2，即3=1+1+1，3=3；
     * <p>
     * （3）、实施递推；
     * <p>
     * 根据以上递推关系与初始条件设置一重k（4~n）循环，循环外确定初始条件，循环内实施递推：
     * <p>
     * f[k]=f[k-1]+f[k-3]，即可求出f（n）；//与斐波那契数列的求解一样
     * 此具体案例的递推设计比较简单，时间复杂度为O（n）；
     *
     * @param n n
     */
    private static int solution1(int n) {
        //f（1）=1，即1=1；
        //f（2）=1，即2=1+1（注意：跳法中不允许直接跳2级）；
        if (n == 1 || n == 2) {
            return 1;
        }
        //f（3）=2，即3=1+1+1，3=3；
        if (n == 3) {
            return 2;
        }

        return solution1(n - 1) + solution1(n - 3);
    }


}
