package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * 단어 공부 (https://www.acmicpc.net/problem/1157)
 */
public class BOJ_1157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Long> collect = Arrays.stream(br.readLine().toUpperCase().split(""))
                .collect(Collectors.groupingBy(s -> s, counting()));

        Long count = 0L;
        List<String> words = new ArrayList<>();
        for (Map.Entry<String, Long> stringLongEntry : collect.entrySet()) {
            if (stringLongEntry.getValue() > count) {
                words.clear();
                words.add(stringLongEntry.getKey());
                count = stringLongEntry.getValue();
            } else if (stringLongEntry.getValue().equals(count)) {
                words.add(stringLongEntry.getKey());
            }
        }

        if (words.size() >= 2) {
            bw.write("?");
        } else {
            bw.write(words.get(0));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
