public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "(){}[]";
        String s1 = "   {()}[(])  ";
        s1.trim();
        System.out.println(s1.trim().charAt(0));


    }

    public static boolean isPairValid(char left, char right) {
        if (left == '[' && right == ']') return true;
        else if (left == '(' && right == ')') return true;
        else if (left == '{' && right == '}') return true;
        else return false;
    }
}
