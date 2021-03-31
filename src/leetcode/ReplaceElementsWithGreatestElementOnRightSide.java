package leetcode;

/**
 * 1299. Replace Elements with Greatest Element on Right Side (https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/)
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        int maxVal = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maxVal;
            maxVal = Math.max(maxVal, temp);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] ints = new ReplaceElementsWithGreatestElementOnRightSide()
                .replaceElements(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
