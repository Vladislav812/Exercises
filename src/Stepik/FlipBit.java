package Stepik;

public class FlipBit {

    public static int flipBit(int value, int bitIndex) {
        int neg = 0;
        if (value < 0) {
            value = -value;
            neg = -1;
        }
        String s1 = toBinary(value);
        String s2 = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (i == s1.length() - bitIndex)
                s2 = flip(Integer.parseInt(Character.toString(s1.charAt(i)))) + s2;
            else
                s2 = s1.charAt(i) + s2;
        }
        System.out.println(s1 + "\n" + s2);
        if (neg == -1)
            return -toDecimal(s2);
        else return toDecimal(s2);
    }

    public static void main(String[] args) {
        int a = flipBit(-13, 4);
        String str = toBinary(a);
        System.out.println("\n" + str + "\n" + a);
    }

    public static int flip(int a) {
        if (a == 0)
            return 1;
        else return 0;
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
