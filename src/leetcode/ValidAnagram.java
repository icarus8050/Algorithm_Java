package leetcode;

/**
 * 242. Valid Anagram (https://leetcode.com/problems/valid-anagram/)
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[t.charAt(i) - 97]++;
            cnt[s.charAt(i) - 97]--;
        }

        for (int i : cnt) {
            if (i != 0) return false;
        }

        return true;
    }
}
