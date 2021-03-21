package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 소트인사이드 (https://www.acmicpc.net/problem/1427)
 */
public class BOJ_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int[] arr = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            arr[i] = Character.getNumericValue(chars[i]);
        }

        List<Integer> collect = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        collect.forEach(System.out::print);
        System.out.println();

        sc.close();
    }
}
