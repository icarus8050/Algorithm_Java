package leetcode;

/**
 * 171. Excel Sheet Column Number (https://leetcode.com/problems/excel-sheet-column-number/)
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        char[] chars = columnTitle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += (chars[i] - 64) * Math.pow(26, chars.length - i - 1);
        }

        return result;
    }
}
