package Leetcode;

import java.util.ArrayList;

public class DetonateTheMaximumBombs2101 {

    public static void main(String[] args) {
        //int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        //int[][] bombs = {{1, 1, 5}, {10, 10, 5}};
        //int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
        //int[][] bombs = {{0, 0, 5}, {10, 0, 5}};
        int[][] bombs = {{54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3}, {11, 20, 3}, {2, 57, 1}, {69, 51, 7}, {97, 1, 10}, {85, 45, 2}, {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2}, {20, 97, 8}, {35, 37, 3}};
        System.out.println(maximumDetonation(bombs));
    }

    public static int maximumDetonation(int[][] bombs) {
        boolean[][] explosions = new boolean[bombs.length][bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }
                double dist = Math.sqrt(Math.pow(bombs[j][0] - bombs[i][0], 2) + Math.pow(bombs[j][1] - bombs[i][1], 2));
                explosions[i][j] = bombs[i][2] >= dist;
            }
        }


        int maxChain = 0;
        for (int i = 0; i < bombs.length; i++) {
            ArrayList<Integer> chain = new ArrayList<>();
            chain.add(i);
            for (int j = 0; j < bombs.length; j++) {
                if (isInChain(chain, j)) {
                    continue;
                }

                for (int k = 0; k < chain.size(); k++) {
                    if (explosions[chain.get(k)][j]) {
                        chain.add(j);
                        j = -1;
                        break;
                    }
                }
            }
            if (chain.size() > maxChain) {
                maxChain = chain.size();
            }
        }
        return maxChain;
    }

    static boolean isInChain(ArrayList<Integer> chain, int bombIndex) {
        for (int chainBomb : chain) {
            if (chainBomb == bombIndex) {
                return true;
            }
        }
        return false;
    }


}
