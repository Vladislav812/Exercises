package JetBrains;

import java.util.Scanner;

public class PrintNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        boolean exit = false;
        for (int i = 1; !exit; i++) {
            for (int j = 1; j <= i; j++) {
                if (count == n) {
                    exit = true;
                    break;
                }
                if (count < n - 1) {
                    System.out.print(i + " ");
                    count++;
                } else {
                    System.out.print(i);
                    count++;
                }
            }
        }
    }
}
