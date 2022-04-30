package leetcode;

/**
 * 168. Excel Sheet Column Title (https://leetcode.com/problems/excel-sheet-column-title/)
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}
