import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<Character> st = new Stack<>();
        Stack<Integer> cnt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char str;
            if (isBracket(s.charAt(i))) {
                str = s.charAt(i);
            } else continue;

            if (st.isEmpty()) {
                st.push(str);
                cnt.push(i + 1);
            } else {
                char ch = st.peek();
                if (isRBracket(ch))
                    break;

                if (bracketMatch(ch, str)) {
                    st.pop();
                    cnt.pop();
                } else {
                    st.push(str);
                    cnt.push(i + 1);
                }
            }
        }
        if (!st.isEmpty()) {
            System.out.println(cnt.pop());
        } else {
            System.out.println("Success");
        }
    }

    static boolean isBracket(char ch) {
        if (ch == '(' || ch == ')' ||
                ch == '[' || ch == ']' ||
                ch == '{' || ch == '}')
            return true;
        else return false;
    }

    static boolean isRBracket(char ch) {
        if (ch == ')' || ch == ']' ||
                ch == '}')
            return true;
        else return false;
    }

    static boolean bracketMatch(char L, char R) {
        if (L == '(' && R == ')' ||
                L == '[' && R == ']' ||
                L == '{' && R == '}')
            return true;
        else return false;
    }

}
