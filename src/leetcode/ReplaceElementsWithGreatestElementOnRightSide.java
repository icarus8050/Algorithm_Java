package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1299. Replace Elements with Greatest Element on Right Side (https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/)
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int maxVal = 0;
            for (int j = i + 1; j < length; j++) {
                maxVal = Math.max(maxVal, arr[j]);
            }
            arr[i] = maxVal;
        }

        arr[length - 1] = -1;

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] ints = new ReplaceElementsWithGreatestElementOnRightSide()
                .replaceElements(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
