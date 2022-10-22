package leetcode;

/**
 * 205. Isomorphic Strings (https://leetcode.com/problems/isomorphic-strings/)
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
    }
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[512];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (map[s1] != map[t1 + 256]) {
                return false;
            }
            map[s1] = map[t1 + 256] = i + 1;
        }
        return true;
    }
}
