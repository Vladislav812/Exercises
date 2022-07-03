package JetBrains;

import java.util.Scanner;

public class DivisibleByN {
    class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            int count = a % n == 0 || b % n == 0 ? (b - a) / n + 1 : (b - a - n + a % n) / n + 1;
            System.out.println(count);
        }
    }
}
