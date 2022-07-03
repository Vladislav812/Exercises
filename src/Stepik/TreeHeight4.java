package Stepik;

import java.util.ArrayList;
import java.util.Scanner;

//KoHHeKT: теперь надо подумать, как сделать так, чтобы не создавать новый массив children на каждый вызов findHeight
// Работает, тесты проходит
public class TreeHeight4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }
        ArrayList<Integer>[] children = getChildren(tree);
        int root = getRoot(tree);
        System.out.println(findHeight(children, root));
    }

    public static int findHeight(ArrayList<Integer>[] children, int root) {
        if (children[root].size() == 0) {
            return 1;
        }

        int max = 0;
        for (int child : children[root]) {
            int height = findHeight(children, child);
            max = Math.max(max, height);
        }
        return max + 1;

    }

    public static ArrayList<Integer>[] getChildren(int[] tree) {
        ArrayList<Integer>[] children = new ArrayList[tree.length];

        for (int i = 0; i < tree.length; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != -1) {
                children[tree[i]].add(i);
            }
        }

        return children;
    }

    public static int getRoot(int[] tree) {
        int i = 0;
        for (; i < tree.length; i++) {
            if (tree[i] == -1) {
                break;
            }
        }
        return i;
    }
}
