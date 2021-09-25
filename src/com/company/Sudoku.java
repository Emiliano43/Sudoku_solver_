package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Sudoku {
    private char[][] board;

    public char[][] getBoard() {
        return board;
    }

    Sudoku() {
        this.board = new char[9][9];
    }

    public boolean isValid() {
        HashSet seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add("row" + i + board[i][j]) || !seen.add("column" + j + board[i][j])) {
                        return false;
                    }
                    if (!seen.add("box" + (i / 3) * 3 + j / 3 + board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public char[][] reading(String filename) throws IOException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            for (int i = 0; i < 9; i++) {
                board[i] = scanner.nextLine().toCharArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return board;
    }

    public void solution() {

        solve(0, 0);
    }

    private boolean solve(int row, int column) {
        if (column == 9) {
            column = 0;
            row++;
            if (row == 9) {
                return true;
            }
        }
        //if the current index is not empty then check for next index value
        if (board[row][column] != '.') {
            return solve(row, column + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (check(row, column, ch)) {
                board[row][column] = ch;
                if (solve(row, column + 1)) {
                    return true;
                }
                board[row][column] = '.';
            }
        }
        return false;
    }

    private boolean check(int row, int column, char ch) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == ch || board[k][column] == ch) return false;
        }

        //calculating starting row and col at the particular index
        int smi = (row / 3) * 3;
        int smj = (column / 3) * 3;

        //check in their 3x3 boxes if the current value is already present
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[smi + k][smj + l] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
