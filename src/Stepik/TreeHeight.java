package Stepik;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }
        System.out.println(findHeight(tree, -1) - 1);
    }

    public static int findHeight(int[] tree, int root) {
        ArrayList<Integer> children = new ArrayList();
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == root) {
                children.add(i);
            }
        }
        if (children.size() == 0)
            return 1;

        else {
            int maxLength = 0;
            for (int r : children) {
                int length = findHeight(tree, r);
                if (maxLength < length)
                    maxLength = length;
            }
            return maxLength + 1;
        }
    }
}
