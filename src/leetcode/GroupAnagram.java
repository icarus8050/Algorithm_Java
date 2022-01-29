package leetcode;

import java.util.*;

/**
 * 49. Group Anagram (https://leetcode.com/problems/group-anagrams/)
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sortedString = getSortedString(str);
            map.compute(sortedString, (k, v) -> {
                if (v == null) {
                    List<String> anagram = new ArrayList<>();
                    anagram.add(str);
                    return anagram;
                }
                v.add(str);
                return v;
            });
        }
        return new ArrayList<>(map.values());
    }

    private String getSortedString(String str) {
        char[] sortedChars = str.toCharArray();
        Arrays.sort(sortedChars);
        return new String(sortedChars);
    }
}
