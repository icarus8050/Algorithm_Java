package leetcode;

/**
 * 292. Nim Game (https://leetcode.com/problems/nim-game/)
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
