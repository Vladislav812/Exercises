package Stepik;

import java.util.Arrays;

class MergeArrays {
    public static void main(String[] args) {
        int[] a1 = {0, 2, 20};
        int[] a2 = {10, 200};
        System.out.println(Arrays.toString(mergeArrays(a1, a2)));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] merge = new int[a1.length + a2.length];
        int a = 0, b = 0, i = 0;
        while (i < merge.length) {
            if ((a < a1.length) && (b >= a2.length || a1[a] < a2[b])) {
                merge[i] = a1[a];
                i++;
                a++;
            } else {
                merge[i] = a2[b];
                i++;
                b++;
            }

        }
        return merge;
    }

}
