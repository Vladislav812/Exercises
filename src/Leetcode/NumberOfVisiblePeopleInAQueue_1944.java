//quadratic solution O(n^2)

package Leetcode;

import java.util.Arrays;

public class NumberOfVisiblePeopleInAQueue_1944 {
    public static void main(String[] args) {
        int[] ar = {10, 6, 8, 5, 11, 9};
        //int[] ar = {5, 1, 2, 3, 10};
        System.out.println(Arrays.toString(canSeePersonsCount(ar)));
        // System.out.println(Arrays.toString(ar));
    }

    public static int[] canSeePersonsCount(int[] heights) {
        if (heights.length == 1)
            return new int[]{0};
        if (heights.length == 2)
            return new int[]{1, 0};

        int[] out = new int[heights.length];
        Arrays.fill(out, 1);
        out[out.length - 1] = 0;
        int max = 0;

        for (int i = 0; i < heights.length - 2; i++) {
            max = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (max == 0) {
                    max = heights[j];
                    continue;
                } else if (max < Math.min(heights[i], heights[j])) {
                    out[i]++;
                }
                max = Math.max(max, heights[j]);
            }
        }
        return out;
    }
}
