import java.util.Scanner;


public class Euclid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        System.out.println(gcd(p, q));
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        System.out.println(p + " " + q);
        return gcd(q, r);
    }

}
