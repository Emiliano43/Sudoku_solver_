package com.company;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    Sudoku sudoku = new Sudoku();
    String filename = "C:\\Users\\enazy\\IdeaProjects\\Sudoku_solver_\\src\\sudoku_input.txt";
    char[][] trueArray = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    @org.junit.jupiter.api.Test
    void testingValid() {
        try {
            sudoku.reading(filename);
            //correct in the same subgrid
            sudoku.getBoard()[0][2] = '1';
            assertTrue(sudoku.isValid());

            //incorrect in the same row
            sudoku.getBoard()[0][4] = '5';
            assertFalse(sudoku.isValid());

            //in correct in the same column
            sudoku.getBoard()[6][0] = '5';
            assertFalse(sudoku.isValid());

            //incorrect in the same sub grid
            sudoku.getBoard()[1][1] = '5';
            assertFalse(sudoku.isValid());

            //incorrect in the same sub grid and column
            sudoku.getBoard()[1][1] = '9';
            assertFalse(sudoku.isValid());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void testingReadingFromFile() {
        try {
            assertTrue(Arrays.deepEquals(sudoku.reading(filename), trueArray));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void testingSolution() {
        try {
            char[][] expected = {
                    {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                    {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                    {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                    {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                    {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                    {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                    {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                    {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                    {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
            sudoku.reading(filename);
            sudoku.solution();
            char[][]real = sudoku.getBoard();

            assertTrue(Arrays.deepEquals(real, expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}