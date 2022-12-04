package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 팔찌 만들기 (https://www.acmicpc.net/problem/25707)
 */
public class BOJ_25707 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += (arr[i] - arr[i - 1]);
        }
        sum += (arr[arr.length - 1] - arr[0]);

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
