package leetcode;

/**
 * 125. Valid Palindrome (https://leetcode.com/problems/valid-palindrome/)
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.trim().toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char aChar : chars) {
            if ((aChar >= 'a' && aChar <= 'z') ||
                    (aChar >= 'A' && aChar <= 'Z') ||
                    (aChar >= '0' && aChar <= '9')) {
                builder.append(aChar);
            }
        }

        char[] alphabets = builder.toString().toCharArray();

        for (int i = 0; i < alphabets.length / 2; i++) {
            if (alphabets[i] != alphabets[alphabets.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
