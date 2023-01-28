package programmers;

import java.time.LocalDate;
import java.util.*;

/**
 * 개인정보 수집 유효기간 (https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=java)
 */
public class Lessons_150370 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lessons_150370().solution("2020.01.01", new String[]{"D 5"}, new String[]{"2019.07.01 D"})));
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        String[] currentDate = today.split("\\.");
        LocalDate currentLocalDate = LocalDate.of(Integer.parseInt(currentDate[0]), Integer.parseInt(currentDate[1]), Integer.parseInt(currentDate[2]));
        Map<String, Integer> termsMap = formattingTerms(terms);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] collectedDate = privacy[0].split("\\.");
            String termsType = privacy[1];
            LocalDate collectedLocalDate = LocalDate.of(Integer.parseInt(collectedDate[0]), Integer.parseInt(collectedDate[1]), Integer.parseInt(collectedDate[2]));
            LocalDate expiredLocalDate = collectedLocalDate.plusMonths(termsMap.get(termsType));
            if (currentLocalDate.isAfter(expiredLocalDate) || currentLocalDate.isEqual(expiredLocalDate)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private Map<String, Integer> formattingTerms(String[] terms) {
        Map<String, Integer> termsMap = new HashMap<>();
        Arrays.stream(terms)
                .forEach(s -> {
                    String[] temp = s.split(" ");
                    termsMap.put(temp[0], Integer.parseInt(temp[1]));
                });
        return termsMap;
    }
}
