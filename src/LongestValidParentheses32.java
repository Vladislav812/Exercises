import java.util.Arrays;
import java.util.Stack;

public class LongestValidParentheses32 {
    public static void main(String[] args) {
        //String s = ")()(((())))(()))))(((())))())";
        //String s = "()()";
        //String s = "(()())";
        // String s = "))";
        //String s = "";
        //String s = ")()())))";
        //String s = "(()";
        String s = "())))";
        //String s = "(()))";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        if (s.isEmpty()) return 0;
        Stack<Character> st = new Stack<>();

        int[] height = new int[s.length() + 2];
        for (int i = 0; i < s.length(); i++) {
            height[i + 1] = st.size();
            if (!st.isEmpty() && st.peek() == '(' && s.charAt(i) == ')')
                st.pop();
            else st.push(s.charAt(i));
        }
        if (st.isEmpty()) return s.length();
        height[0] = 0;
        height[s.length() + 1] = st.size();
        System.out.println(Arrays.toString(height));

        int n = height[height.length - 1];

        Stack<int[]> parts = new Stack<>();
        parts.push(new int[]{height.length - 1, height.length - 1});
        int j = height.length;
        while (true) {
            System.out.println(j + " | " + Arrays.toString(parts.peek()));
            for (int i = parts.peek()[1]; i > 0; i--) {
                j = i;
                if (height[i - 1] < n) {
                    parts.peek()[0] = i;
                    break;
                }
            }

            for (int i = parts.peek()[0]; i >= 0; i--) {
                j = i;
                if (height[i - 1] > height[i] || i <= 1) {
                    parts.push(new int[]{i, i});
                    break;
                }
            }

            n = height[parts.peek()[1]];
            if (n == 0) {
                j = 1;
                parts.peek()[0] = 1;
            }
            if (j <= 1) break;
        }

        printStack(parts);
        int max = 0;
        while (!parts.isEmpty()) {
            System.out.println("max = " + max);
            max = Math.max(max, parts.peek()[1] - parts.peek()[0]);
            parts.pop();

        }

        return max;
    }

    public static void printStack(Stack<int[]> stack) {
        Stack<int[]> copy = (Stack<int[]>) stack.clone();
        while (!copy.isEmpty()) {
            System.out.println(Arrays.toString(copy.pop()));
        }
    }
}
