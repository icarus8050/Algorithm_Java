package programmers;

/**
 * 문자열 압축 (https://programmers.co.kr/learn/courses/30/lessons/60057)
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(new StringCompression().solution("aabbaccc"));
    }
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int cnt = 1;
            String unit = s.substring(0, i);
            StringBuilder sb = new StringBuilder();

            for (int j = i; j <= s.length(); j += i) {
                String temp = s.substring(j, Math.min(j + i, s.length()));

                if (unit.equals(temp)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(unit);
                    cnt = 1;
                    unit = temp;
                }
            }
            sb.append(unit);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
