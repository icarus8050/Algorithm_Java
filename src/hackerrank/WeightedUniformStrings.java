package hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Weighted Uniform Strings (https://www.hackerrank.com/challenges/weighted-uniform-string/problem?isFullScreen=true)
 */
public class WeightedUniformStrings {

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        List<String> results = new ArrayList<>();
        Set<Integer> weights = new HashSet<>();

        char prevC = '-';
        int sumWeight = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int weight = c - 96;

            if (prevC == c) {
                sumWeight += weight;
            } else {
                prevC = c;
                sumWeight = weight;
            }

            weights.add(sumWeight);
        }

        queries.forEach(q -> {
            if (weights.contains(q)) {
                results.add("Yes");
            } else {
                results.add("No");
            }
        });

        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = WeightedUniformStrings.weightedUniformStrings(s, queries);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
