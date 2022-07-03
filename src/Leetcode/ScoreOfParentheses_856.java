package Leetcode;

import java.util.Stack;

public class ScoreOfParentheses_856 {

    public static void main(String[] args) {
        String s = "((()())())";

        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {
        int counter = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                counter += Math.pow(2, stack.size());
                i++;
            } else if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return counter;
    }
}
