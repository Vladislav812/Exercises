public class Main {
    public static void main(String[] args) {
        String s = args[0];
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        System.out.printf("name" + "  a  " + "  b  " + "quotient" + "\n"
                + "%.4s" + "%4s" + "%4s" + "   %.3f", s, a, b, (double) a / b);
    }
}
