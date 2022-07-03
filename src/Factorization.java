public class Factorization {
    public static void main(String[] args) {
        Long n = Long.parseLong(args[0]);
        for (int factor = 2; factor <= n / 2; factor++) {
            while (n % factor == 0) {
                System.out.print(factor + " ");
                n /= factor;
            }
        }
        if (n > 1)
            System.out.print(n);
    }
}
