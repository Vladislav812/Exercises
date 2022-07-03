package Stepik;

public class ToBinary {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        String s = toBinary(a);
        System.out.println(toBinary(a));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(toDecimal(s));
        System.out.println(10 ^ 0);
    }

    public static String toBinary(int a) {
        if (a == 0)
            return "0";
        String s = "";
        while (a >= 1) {
            s = a % 2 + s;
            a /= 2;
        }
        return s;
    }

    public static int toDecimal(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            a += Integer.parseInt(Character.toString(s.charAt(i))) * Math.pow(2, s.length() - i - 1);
        }
        return a;
    }
}
