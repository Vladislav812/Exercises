package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges_994 {
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
        List<int[]> rottenList;
        //printGrid(grid);
        while (prevNumberOfFresh != currNumberOfFresh) {
            prevNumberOfFresh = currNumberOfFresh;
            rottenList = getRotten(grid);
            while (!rottenList.isEmpty()) {
                int[] or = rottenList.remove(rottenList.size() - 1);
                currNumberOfFresh -= makeRotAround(grid, or[0], or[1]);
            }
            time++;
            //printGrid(grid);
        }
        return currNumberOfFresh == 0 ? time - 1 : -1;
    }


    static int makeRotAround(int[][] grid, int i, int j) {
        int count = 0;
        if (i >= 1 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            count++;
        }
        if (j >= 1 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            count++;
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            count++;
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            count++;
        }

        return count;
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

    static List<int[]> getRotten(int[][] grid) {
        List<int[]> rottenList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottenList.add(new int[]{i, j});
                }
            }
        }
        return rottenList;
    }
}
