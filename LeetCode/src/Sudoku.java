/**
 * @author: basavakanaparthi
 * on 12,Oct,2016 at 4:00 PM.
 */
public class Sudoku {
        public void solveSudoku(char[][] board) {
            if(board.length == 0 || board[0].length == 0 || board == null)
                return;
            solve(board);
        }

        public boolean solve(char[][] board)
        {
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == '.'){
                        for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9 for each cell
                            if(isValid(board, i, j, c)){
                                board[i][j] = c; //Put c for this cell

                                if(solve(board))
                                    return true; //If it's the solution return true
                                else
                                    board[i][j] = '.'; //Otherwise go back
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isValid(char[][] board, int i, int j, char c) {
            for (int row = 0; row < 9; row++)
                if (board[row][j] == c)
                    return false;

            for (int col = 0; col < 9; col++)
                if (board[i][col] == c)
                    return false;

            for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
                for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                    if (board[row][col] == c)
                        return false;
            return true;
        }
}
