public class Hellos {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        for (int i = 1; i <= n; i++) {
            int j = (int) i % 10;
            int k = (int) ((i - j) % 100);
            if (j == 1 && k != 10) System.out.println(i + "st Hello");
            else if (j == 2 && k != 10) System.out.println(i + "nd Hello");
            else if (j == 3 && k != 10) System.out.println(i + "rd Hello");
            else System.out.println(i + "th Hello");

        }

    }
}
