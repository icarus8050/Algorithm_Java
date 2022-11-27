package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * ATM (https://www.acmicpc.net/problem/11399)
 */
public class BOJ_11399 {
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
        int acc = 0;
        int answer = 0;
        for (int i = 1; i < n; i++) {
             acc = arr[i - 1] + acc;
             answer += (acc + arr[i]);
        }

        bw.write(answer + arr[0] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
