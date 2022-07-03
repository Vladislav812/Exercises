package Stepik;
//KoHHeKT: ещё можно сделать оптимизацию, чтобы высота каждого узла вычислялась только один раз и переиспользовалась

import java.util.Scanner;

public class TreeHeight2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int length = 0;
            int j = i;
            while (j != -1) {
                j = tree[j];
                length++;
            }
            if (maxLength < length)
                maxLength = length;
        }

        System.out.println(maxLength);
    }

}
