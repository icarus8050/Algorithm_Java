package leetcode;

/**
 * 405. Convert a Number to Hexadecimal (https://leetcode.com/problems/convert-a-number-to-hexadecimal/)
 */
public class ConvertANumberToHexadecimal {
    char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.insert(0, hex[(num & 15)]);
            num = (num >>> 4);
        }
        return result.toString();
    }
}
