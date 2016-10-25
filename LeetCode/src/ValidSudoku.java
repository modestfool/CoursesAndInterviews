/**
 * @author: basavakanaparthi
 * on 12,Oct,2016 at 4:02 PM.
 */
/*
    https://leetcode.com/problems/valid-sudoku/
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (used[board[i][j]]);
            }
        }
        return true;
    }
}
