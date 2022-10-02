package hackerrank;

import java.io.*;

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
}
