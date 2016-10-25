import java.util.Arrays;

/**
 * @author: basavakanaparthi
 * on 24,Oct,2016 at 11:36 PM.
 */
/*
    https://leetcode.com/problems/game-of-life/
    According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up:
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife_289 {

    public static void gameOfLife(int[][] board)
    {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++)
        {
            for (int j = 0;j < n; j++)
            {
                int neighbors = getNeighbors(board,m,n,i,j);
                if (board[i][j] == 1 && (neighbors == 2 || neighbors == 3))
                {
                    board[i][j] = 3;
                }
                else if (neighbors == 3)
                    board[i][j] = 2;
            }
        }
        for(int i = 0; i < m; i++)
        {
            for (int j = 0;j < n; j++)
            {
                board[i][j] /= 2;
            }
        }
    }

    public static int getNeighbors(int[][] board, int m, int n, int row, int col)
    {
        int lives = 0;
        for (int i = Math.max(row-1,0); i <= Math.min(row+1,m-1); i++)
        {
            for (int j = Math.max(col-1,0); j <= Math.min(col+1, n-1); j++)
            {
                lives += board[i][j] & 1;
            }
        }
        lives -= board[row][col];
        return lives;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,1,0},{0,0,1}};
        for(int[] arr: board)
        System.out.println(Arrays.toString(arr));
        gameOfLife(board);
        for(int[] arr: board)
            System.out.println(Arrays.toString(arr));
    }
}
