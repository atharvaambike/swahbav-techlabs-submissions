package com.aurionpro.model;

public class StandardTicTacToeRule implements IGameRule {

    @Override
    public boolean checkWin(Board board, MarkType mark) {
        int size = 3;

        // Check rows
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board.getMarkAt(i, j) != mark) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (board.getMarkAt(i, j) != mark) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check main diagonal
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board.getMarkAt(i, i) != mark) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check anti-diagonal
        win = true;
        for (int i = 0; i < size; i++) {
            if (board.getMarkAt(i, size - i - 1) != mark) {
                win = false;
                break;
            }
        }
        return win;
    }
}
