package leetcode;

/**
 * 231. Power of Two (https://leetcode.com/problems/power-of-two/)
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 32; i++) {
            if (n == Math.pow(2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfTwo2(int n) {
        return (n & (n - 1)) == 0 && n > 0;
    }
}
