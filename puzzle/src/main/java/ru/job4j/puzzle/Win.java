package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (checkVertical(board, i) || checkHorizontal(board, i)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    private static boolean checkHorizontal(int[][] board, int i) {
        boolean rsl = true;
        for (int j = 0; j < board.length; j++) {
            if (board[j][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    private static boolean checkVertical(int[][] board, int i) {
        boolean rsl = true;
        for (int j = 0; j < board.length; j++) {
            if (board[i][j] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
