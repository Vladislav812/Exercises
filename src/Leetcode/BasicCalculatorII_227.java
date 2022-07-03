package Leetcode;

import java.util.Stack;

class BasicCalculatorII_227 {
    public static int calculate(String s) {
        if (s.length() < 3)
            return Integer.parseInt(s);

        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        String number = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;

            if (!isOperator(s.charAt(i)))
                number += Character.toString(s.charAt(i));
            else {
                if (number != "") {
                    nums.push(Integer.parseInt(number));
                    number = "";
                }
                ops.push(s.charAt(i));
            }
        }
        if (number != "")
            nums.push(Integer.parseInt(number));

        nums = reverseNums(nums);
        ops = reverseOps(ops);
        System.out.println(nums.toString());
        System.out.println(ops.toString());
        Stack<Integer> revNums = new Stack<>();
        Stack<Character> revOps = new Stack<>();
        while (!ops.isEmpty()) {
            if (ops.peek() == '/') {
                int right = nums.pop();
                int left = nums.pop();
                nums.push(right / left);
                ops.pop();
            } else if (ops.peek() == '*') {
                int right = nums.pop();
                int left = nums.pop();
                nums.push(left * right);
                ops.pop();
            } else {
                revOps.push(ops.pop());
                revNums.push(nums.pop());
            }
        }


        revNums.push(nums.pop());
        System.out.println(nums.toString());
        System.out.println(ops.toString());
        System.out.println(revNums.toString());
        System.out.println(revOps.toString());
        revNums = reverseNums(revNums);
        revOps = reverseOps(revOps);
        while (!revOps.isEmpty()) {
            System.out.println(revNums.toString());
            System.out.println(revOps.toString());
            char operator = revOps.pop();
            int right = revNums.pop();
            int left = revNums.pop();
            if (operator == '+')
                revNums.push(left + right);
            else revNums.push(-left + right);

        }


        return revNums.pop();
    }

    public static boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            return true;
        else return false;
    }

    public static void main(String[] args) {
        //calculate("3+2000*2*2-1 + 3  *234-10-20/555 ");
        //calculate("3*2");
        System.out.println(calculate("5-2*3"));
    }

    public static Stack<Integer> reverseNums(Stack<Integer> stack) {
        Stack<Integer> out = new Stack<>();
        while (!stack.isEmpty())
            out.push(stack.pop());
        return out;
    }

    public static Stack<Character> reverseOps(Stack<Character> stack) {
        Stack<Character> out = new Stack<>();
        while (!stack.isEmpty())
            out.push(stack.pop());
        return out;
    }

}

