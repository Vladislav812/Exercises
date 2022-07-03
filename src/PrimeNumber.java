public class PrimeNumber {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        for (int factor = 2; factor <= number / factor; factor++) {
            if (number % factor == 0) {
                System.out.println("Number " + number + " is not prime"
                        + "\n" + "Factor is " + factor);
                return;
            }
        }
        System.out.println("Number " + number + " is prime");
    }
}
