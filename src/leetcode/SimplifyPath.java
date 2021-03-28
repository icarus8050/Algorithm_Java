package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. Simplify Path (https://leetcode.com/problems/simplify-path/)
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        int size = path.length();

        String[] splitPath = path.split("/");
        for (String s : splitPath) {
            if (s.isBlank() || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                deque.pollLast();
            }
            else {
                deque.addLast(s);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst())
                    .append("/");
        }

        if (sb.length() != 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();

        System.out.println(simplifyPath.simplifyPath("/a/./b//../../c/"));
    }
}
