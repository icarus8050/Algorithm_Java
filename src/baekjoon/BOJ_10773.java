package baekjoon;

import java.io.*;
import java.util.Stack;

/**
 * 제로 (https://www.acmicpc.net/problem/10773)
 */
public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (k-- > 0) {
            int call = Integer.parseInt(br.readLine());
            if (call == 0 && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(call);
            }
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
