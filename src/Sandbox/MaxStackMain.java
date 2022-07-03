package Sandbox;

import java.util.ArrayList;
import java.util.Scanner;

class MaxStackMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        StackWithMax st = new StackWithMax();
        ArrayList<Integer> arl = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            String s = scanner.nextLine();
            String[] spl = s.split("\\s+");
            String operation = spl[0];
            int value = 0;
            if (spl.length > 1) {
                value = Integer.parseInt(spl[1]);
            }

            switch (operation) {
                case "push" -> st.push(value);
                case "pop" -> {
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                }
                case "max" -> {
                    if (!st.isEmpty()) {
                        sb.append(st.max());
                    } else {
                        sb.append(0);
                    }

                    sb.append("\n");

                }
            }

        }

        System.out.println(sb.toString().trim());
    }
}

