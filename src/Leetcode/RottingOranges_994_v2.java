package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class RottingOranges_994_v2 {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        //int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        //int[][] grid = {{0, 2}};
        System.out.println(orangesRotting(grid));
    }


    public static int orangesRotting(int[][] grid) {
        int prevNumberOfFresh = -1;
        int currNumberOfFresh = countFresh(grid);
        int time = 0;
        Queue<int[]> rottenQueue = getRotten(grid);
        //printGrid(grid);
        while (prevNumberOfFresh != currNumberOfFresh) {
            prevNumberOfFresh = currNumberOfFresh;
            int count = rottenQueue.size();
            while (count > 0) {
                int[] orange = rottenQueue.remove();
                System.out.println(Arrays.toString(orange));
                count--;
                ArrayList<int[]> ar = makeRotAround(grid, orange[0], orange[1]);
                rottenQueue.addAll(ar);
                currNumberOfFresh -= ar.size();
            }
            time++;
            System.out.println();
            //printGrid(grid);
        }
        return currNumberOfFresh == 0 ? time - 1 : -1;
    }


    static ArrayList<int[]> makeRotAround(int[][] grid, int i, int j) {
        ArrayList<int[]> ar = new ArrayList<>();
        int count = 0;
        if (i >= 1 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            ar.add(new int[]{i - 1, j});
        }
        if (j >= 1 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            ar.add(new int[]{i, j - 1});
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            ar.add(new int[]{i + 1, j});
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            ar.add(new int[]{i, j + 1});
        }
        return ar;
    }


    static int countFresh(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    static Queue<int[]> getRotten(int[][] grid) {
        Queue<int[]> rottenQueue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottenQueue.add(new int[]{i, j});
                }
            }
        }
        return rottenQueue;
    }
}
