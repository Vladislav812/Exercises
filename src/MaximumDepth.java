import javax.swing.*;
import java.util.Stack;

public class MaximumDepth {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1", s2 = "(1)+(sdf)+(sdf)+((2))+(((3)))";
        s = s2;
        Stack<Character> st = new Stack<>();
        int dep = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
                if (st.size() > dep)
                    dep = st.size();
            } else if (s.charAt(i) == ')')
                st.pop();
        }

        JOptionPane.showMessageDialog(null, dep);
    }
}
