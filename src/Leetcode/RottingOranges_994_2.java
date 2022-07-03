package Leetcode;

public class RottingOranges_994_2 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int time = 0;
            while (areAllRotten()) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == 2) {
                            if ()
                        }
                    }
                }

                time++;
            }


            return time;
        }

        static boolean areAllRotten(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        static int[][] getAdjacent(int[][] grid, int i, int j) {


        }
    }
}
