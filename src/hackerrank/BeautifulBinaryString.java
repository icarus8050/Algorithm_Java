package hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Beautiful Binary String (https://www.hackerrank.com/challenges/beautiful-binary-string/problem)
 */
public class BeautifulBinaryString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int beautifulBinaryString(String b) {
        // Write your code here
        int index = 0;
        StringBuilder sb = new StringBuilder(b);
        int result = 0;
        while (index < b.length()) {
            int indexOf = sb.indexOf("010", index);
            if (indexOf == -1) {
                return result;
            }
            sb.replace(indexOf + 2, indexOf + 3, "1");
            index = indexOf + 2;
            result++;
        }
        return result;
    }

    // advanced solving
    /*public static int beautifulBinaryString(String b) {
        List<String> allMatches = new ArrayList<>();
        Matcher matcher = Pattern.compile("010").matcher(b);
        while (matcher.find()) {
            allMatches.add(matcher.group());
        }
        return allMatches.size();
    }*/
}
