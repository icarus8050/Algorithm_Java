package hackerrank;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Pangrams (https://www.hackerrank.com/challenges/pangrams/problem?isFullScreen=true)
 */
public class Pangrams {

    public static String pangrams(String s) {
        Set<Character> characterSet = new HashSet<>();

        for (char c : s.toLowerCase().toCharArray()) {
            if ((c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z'))
                characterSet.add(c);
        }

        return characterSet.size() == 26 ? "pangram" : "not pangram";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Pangrams.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
