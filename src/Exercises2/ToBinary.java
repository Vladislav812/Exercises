package Exercises2;

public class ToBinary {
    public static void main(String[] args) {
        int x = 1;
        int n = x;
        String s = "";
        while (n > 0) {
            s = n % 2 + s;
            n /= 2;
        }
        System.out.println(s);
        System.out.println(Integer.toBinaryString(x));
    }
}
