package leetcode;

import java.util.Arrays;

/**
 * 2037. Minimum Number of Moves to Seat Everyone (https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/)
 */
public class MinimumNumberOfMovesToSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        int result = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < seats.length; i++) {
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }
}
