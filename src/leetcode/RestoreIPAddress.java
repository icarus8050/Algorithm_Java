package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses (https://leetcode.com/problems/restore-ip-addresses/)
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return List.of();
        }
        List<String> ans = new ArrayList<>();
        restore(s, new ArrayList<>(), 0, ans);
        return ans;
    }

    public void restore(String s, List<Integer> ip, int idx, List<String> ans) {
        if (ip.size() == 4 && idx == s.length()) {
            ans.add(ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
            return;
        }

        for (int i = 1; i <= 3 && idx + i <= s.length(); i++) {
            String num = s.substring(idx, idx + i);
            if (num.charAt(0) == '0' && i != 1) {
                break;
            }

            int ipPart = Integer.parseInt(num);
            if (ipPart <= 255) {
                ip.add(ipPart);
                restore(s, ip, idx + i, ans);
                ip.remove(ip.size() - 1);
            }
        }
    }
}
