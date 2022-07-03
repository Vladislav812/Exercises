package JetBrains;

import java.util.Scanner;

public class RightRotation2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();

        String[] items = s.split("\\s+");
        int[] ar = new int[items.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(items[i]);
        }
        ar = rotateArray(ar, k);
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]);
            if (i < ar.length - 1) {
                System.out.print(" ");
            }
        }
    }

    private static int[] rotateArray(int[] ar, int n) {
        int[] out = new int[ar.length];
        int bias = n % ar.length;

        for (int i = 0; i < out.length; i++) {
            int j = i + bias;
            if (j > ar.length - 1) {
                j -= ar.length;
            }
            out[j] = ar[i];
        }
        return out;
    }
}
