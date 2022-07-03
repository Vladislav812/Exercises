package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class DetonateTheMaximumBombs2101_V2 {

    public static void main(String[] args) {
        int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        //int[][] bombs = {{1, 1, 5}, {10, 10, 5}};
        //int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
        //int[][] bombs = {{0, 0, 5}, {10, 0, 5}};
        //int[][] bombs = {{54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3}, {11, 20, 3}, {2, 57, 1}, {69, 51, 7}, {97, 1, 10}, {85, 45, 2}, {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2}, {20, 97, 8}, {35, 37, 3}};
        System.out.println(maximumDetonation(bombs));
    }

    //TC: O(n^2)*queue.length
    public static int maximumDetonation(int[][] bombs) {
        //check all possible pairs of bombs for detonation
        boolean[][] explosions = new boolean[bombs.length][bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }
                long dx = bombs[j][0] - bombs[i][0];
                long dy = bombs[j][1] - bombs[i][1];
                long dist2 = dx * dx + dy * dy;
                long r = bombs[i][2];
                explosions[i][j] = r * r >= dist2;
            }
        }

        int maxChain = 0;
        //fixing one bomb and assess its detonation chain:
        for (int i = 0; i < bombs.length; i++) {
            Queue<Integer> chain = new ArrayDeque<>();//running chain of detonating bombs;
            int[] inChain = new int[bombs.length];//checks if bomb is already in chain

            chain.add(i);
            inChain[i] = 1;

            while (!chain.isEmpty()) {
                int current = chain.poll();
                for (int j = 0; j < bombs.length; j++) {
                    if (inChain[j] == 0 && explosions[current][j]) {
                        chain.add(j);
                        inChain[j] = 1;
                    }
                }
            }

            int inChainLength = countChainLength(inChain);
            maxChain = Math.max(inChainLength, maxChain);
        }
        return maxChain;
    }

    static int countChainLength(int[] ar) {
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        return sum;
    }
}
