import java.util.Stack;

public class SimplifyPath71 {

    public static void main(String[] args) {
        String s = "/../";
        /*
        "/a//b////c/d//././/..";
        "/a/../../b/../c//.//";
        "/../";
        "/home/";
        "/home//foo/";
        "/a/./b/../../c/";
        "/.././GVzvE/./xBjU///../..///././//////T/../../.././zu/q/e"
                */
        System.out.println(simplifyPath(s));

    }

    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        if (path.length() == 1)
            return path;
        int i = 0;
        while (i < path.length() - 1) {   //remove excess slashes
            if (path.charAt(i) == '/' && path.charAt(i + 1) != '/') {
                i++;
                String name = "";
                while (i < path.length() && path.charAt(i) != '/') {
                    name += path.charAt(i);
                    i++;
                }
                st.push(name);
            } else i++;
        }

        Stack<String> st2 = new Stack<>();  //remove single dots
        while (!st.isEmpty()) {
            if (st.peek().equals("."))
                st.pop();
            else st2.push(st.pop());

        }


        while (!st2.isEmpty()) { //process double dots - level up
            if (st2.peek().equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
                st2.pop();
                continue;
            }
            st.push(st2.pop());

        }

        reverse(st);
        return stackToString(st);
    }

    static String stackToString(Stack st) {
        if (st.isEmpty())
            return "/";
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append('/');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    static void reverse(Stack<String> stack) {
        Stack<String> st2 = new Stack<>();
        Stack<String> st3 = new Stack<>();
        while (!stack.isEmpty())
            st2.push(stack.pop());
        while (!st2.isEmpty())
            st3.push(st2.pop());
        while (!st3.isEmpty())
            stack.push(st3.pop());
    }


}
