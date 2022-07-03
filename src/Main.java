public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int a = 0; a <= n; a++) {
            int a3 = a * a * a;
            if (a3 > n) break;
            for (int b = 0; b <= n; b++) {
                int b3 = b * b * b;
                if (a3 + b3 > n) break;
                for (int c = 0; c <= n; c++) {
                    int c3 = c * c * c;
                    if (c3 > a3 + b3) break;
                    for (int d = 0; d <= n; d++) {
                        int d3 = d * d * d;
                        if (d3 + c3 > a3 + b3) break;
                        if (a3 + b3 == c3 + d3 &&
                                a3 + b3 == n &&
                                a != b && a != c && a != d && b != c && b != d && c != d)
                            System.out.println(a + " " + b + " " + c + " " + d);
                    }
                }
            }
        }
    }
}
