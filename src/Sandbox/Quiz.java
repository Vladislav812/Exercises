package Sandbox;

public class Quiz {

    public static void main(String[] args) throws Exception {
        System.out.println(doubleExpression(0.00000000000000001, 0.00000000000000002, 0.00000000000000003));
    }


    public static boolean doubleExpression(double a, double b, double c) {
        if (a + b - c <= 1e-4)
            return true;
        else return false;
    }
}
