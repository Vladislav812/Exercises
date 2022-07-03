package Leetcode;

import java.util.Stack;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        String s = "))((";
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && s.charAt(i) == ')' && st.peek()[1] == '(') {
                st.pop();
            } else if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                st.push(new int[]{i, s.charAt(i)});
            }
        }

        stPrint(st);
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!st.isEmpty() && i == st.peek()[0]) {
                st.pop();
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println("\"" + sb.reverse().toString() + "\"");
    }

    static void stPrint(Stack<int[]> st) {
        Stack<int[]> copy = (Stack<int[]>) st.clone();
        while (!copy.isEmpty()) {
            System.out.print((char) copy.pop()[1] + "  ");
        }
        System.out.println();
        copy = (Stack<int[]>) st.clone();
        while (!copy.isEmpty()) {
            System.out.print(copy.pop()[0] + " ");
        }
    }
}
