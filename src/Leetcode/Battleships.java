package Leetcode;

public class Battleships {
    public static void main(String[] args) {
        //char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', '.'}};
        char[][] board = {{'.'}};
        int count = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == 'X' && !existAdjacent(board, y, x))
                    count++;
            }
        }
        System.out.println(count);
    }

    static boolean existAdjacent(char[][] board, int y, int x) {
        return (y > 0 && board[y - 1][x] == 'X' || x > 0 && board[y][x - 1] == 'X');
    }
}


