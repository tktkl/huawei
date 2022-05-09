import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定两个整数数组，arr1、arr2，数组元素按升序排列；
 * 假设从arr1、arr2中分别取出一个元素，可构成一对元素；
 * 现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值；
 * 注意：两对元素对应arr1、arr2的下标是相同的，视为同一对元素。
 * <p>
 * 输入描述
 * 输入两行数组arr1、arr2
 * 每行首个数字为数组大小size， 0 < size <= 100
 * arr1，arr2中的每个元素e， 0< e <1000
 * 接下来一行，正整数k 0 < k <= arr1.size * arr2.size
 * <p>
 * 输出描述
 * 满足要求的最小值
 *
 * 示例一
 * 输入
 *
 * 1 1 2
 * 1 2 3
 * 2
 * COPY
 * 输出
 *
 * 4
 * COPY
 * 说明：
 * 用例中需要取两个元素，取第一个数组第0个元素与第二个数组第0个元素组成一个元素[1,1];
 * 取第一个数组第1个元素与第二个数组第0个元素组成一个元素[1,1];
 * 求和为1+1+1+1=4 ,满足要求最小
 */
public class _0002 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String arr1Str = scanner.nextLine();
            String arr2Str = scanner.nextLine();
            int range = scanner.nextInt();
            int[] arr1 = parseArray(arr1Str);
            int[] arr2 = parseArray(arr2Str);
            solution(arr1, arr2, range);
        }
    }

    private static void solution(int[] arr1, int[] arr2, int range) {
        List<Integer> sumList = new ArrayList<>(arr1.length * arr2.length);
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr2.length; k++) {
                sumList.add(arr1[i] + arr2[k]);
            }
        }

        sumList.sort(Integer::compareTo);

        int res = 0;
        for (int i = 0; i < range; i++) {
            res += sumList.get(i);
        }
        System.out.println(res);
    }

    public static int[] parseArray(String str) {
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }

}
