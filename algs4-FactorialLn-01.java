import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter N: ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(lnN1(N));
        System.out.println(lnN2(N));

    }

    public static double lnN1(int N) {
        return Math.log(factorial(N));
    }

    public static double lnN2(int N) {
        if (N == 1 || N == 0)
            return 0;
        return lnN2(N - 1) + Math.log(N);
    }


    public static int factorial(int N) {
        if (N == 0)
            return 1;
        int out = 1;
        for (int i = 1; i <= N; i++) {
            out *= i;
        }
        return out;
    }
}


