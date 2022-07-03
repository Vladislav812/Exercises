//реализовано, работает:
//KoHHeKT: ещё можно сделать оптимизацию, чтобы высота каждого узла вычислялась только один раз и переиспользовалась

package Stepik;

import java.util.Scanner;

public class TreeHeight3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }

        int[] heights = new int[tree.length];

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int length = 0;
            int j = i;
            while (j != -1) {
                j = tree[j];
                if (j != -1 && heights[j] != 0) {
                    length = heights[j] + length + 1;
                    break;
                }
                length++;
            }
            if (maxLength < length) {
                maxLength = length;
            }
            heights[i] = length;
            //System.out.println(Arrays.toString(heights));
        }

        System.out.println(maxLength);
    }


}
