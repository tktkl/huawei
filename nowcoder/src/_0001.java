import java.util.Scanner;

/**
 * 题目描述：
 * 如果三个正整数A、B、C ,A²+B²=C²则为勾股数
 * 如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，
 * 则称其为勾股数元组。
 * 请求出给定n~m范围内所有的勾股数元组
 * <p>
 * 输入描述
 * 起始范围
 * 1 < n < 10000
 * n < m < 10000
 * <p>
 * 输出描述
 * ABC保证A<B<C
 * 输出格式A B C
 * 多组勾股数元组，按照A B C升序的排序方式输出。
 * 若给定范围内，找不到勾股数元组时，输出Na。
 * <p>
 * 示例一
 * 输入
 * <p>
 * 1
 * 20
 * COPY
 * 输出
 * <p>
 * 3 4 5
 * 5 12 13
 * 8 15 17
 * COPY
 * 示例二
 * 输入
 * <p>
 * 5
 * 10
 * COPY
 * 输出
 * <p>
 * Na
 */
public class _0001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean noFlag = false;
        for (int a = n; a < m - 1; a++) {
            for (int b = a + 1; b < m; b++) {
                for (int c = b + 1; c < m + 1; c++) {
                    double sqrt = Math.pow(a, 2);
                    double sqrt1 = Math.pow(b, 2);
                    double sqrt2 = Math.pow(c, 2);
                    //两两互质
                    if (relativelyPrime(a, b) && relativelyPrime(a, c) && relativelyPrime(b, c)
                            && sqrt + sqrt1 == sqrt2) {
                        System.out.printf("%d %d %d\n", a, b, c);
                        noFlag = true;
                    }
                }
            }
        }
        if (!noFlag) {
            System.out.println("Na");
        }
    }

    public static boolean relativelyPrime(int x, int y) {
        int min = Math.min(x, y);
        //如果有公约数，两个相余都为0
        for (int i = 2; i <= min; i++) {
            if (x % i == 0 && y % i == 0) {
                return false;
            }
        }
        return true;
    }
}
