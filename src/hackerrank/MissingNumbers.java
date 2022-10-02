package hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Missing Numbers (https://www.hackerrank.com/challenges/missing-numbers/problem)
 */
public class MissingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Long> arrMap = arr.stream()
                .collect(groupingBy(v -> v, counting()));
        Map<Integer, Long> brrMap = brr.stream()
                .collect(groupingBy(v -> v, counting()));

        for (Map.Entry<Integer, Long> brrEntry : brrMap.entrySet()) {
            Integer key = brrEntry.getKey();
            Long value = brrEntry.getValue();

            Long arrValue = arrMap.getOrDefault(key, 0L);
            if (!value.equals(arrValue)) {
                result.add(key);
            }
        }

        Collections.sort(result);
        return result;
    }

    // advanced solving
    /*public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Long> brrMap = brr.stream()
                .collect(groupingBy(v -> v, counting()));

        arr.stream()
                .filter(brrMap::containsKey)
                .forEach(i -> brrMap.put(i, brrMap.get(i) - 1));

        return brrMap.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(Map.Entry::getKey)
                .collect(toList());
    }*/
}
