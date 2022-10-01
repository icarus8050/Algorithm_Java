package hackerrank;

import java.io.*;
import java.util.*;

/**
 * Minimum Absolute Difference In An Array (https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem)
 */
public class MinimumAbsoluteDifferenceInAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] inputs = bufferedReader.readLine().split(" ");
        List<Integer> arr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(inputs[i].trim()));
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        Collections.sort(arr);
        int minimum = Integer.MAX_VALUE;
        int size = arr.size();

        for (int i = 0; i < size - 1; i++) {
            minimum = Math.min(minimum, Math.abs(arr.get(i) - arr.get(i + 1)));
        }
        return minimum;
    }
}
