package hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Sherlock And Anagrams (https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem)
 */
public class SherlockAndAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int sherlockAndAnagrams(String s) {
        List<String> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                result.add(
                        Arrays.stream(s.substring(i, j).split(""))
                                .sorted()
                                .collect(Collectors.joining())
                );
            }
        }
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(i).equals(result.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }
}
