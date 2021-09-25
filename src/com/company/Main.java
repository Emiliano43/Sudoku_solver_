package com.company;


import java.io.IOException;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws IOException {
        Sudoku sudoku = new Sudoku();
        sudoku.reading("C:\\Users\\enazy\\IdeaProjects\\Sudoku_solver_\\src\\sudoku_input.txt");
        System.out.println(sudoku.isValid());

        //System.out.println(Arrays.deepToString(board)); this output isn't beautiful? but the most correct
        for (int i = 0; i < sudoku.getBoard().length; i++) {
            for (int j = 0; j < sudoku.getBoard()[0].length; j++) {
                System.out.print(sudoku.getBoard()[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("The solution of this sudoku: ");
        sudoku.solution();

        for (int i = 0; i < sudoku.getBoard().length; i++) {
            for (int j = 0; j < sudoku.getBoard()[0].length; j++) {
                System.out.print(sudoku.getBoard()[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
