package old;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String s = "{([[[]{}]])}[]";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
                continue;
            }
            if (st.peek() == '(' && s.charAt(i) == ')')
                st.pop();
            else if (st.peek() == '[' && s.charAt(i) == ']')
                st.pop();
            else if (st.peek() == '{' && s.charAt(i) == '}')
                st.pop();
            else st.push(s.charAt(i));
        }

        if (st.isEmpty())
            return true;
        else return false;
    }
}
