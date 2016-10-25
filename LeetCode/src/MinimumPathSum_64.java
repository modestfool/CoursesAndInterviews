import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 06,Oct,2016 at 3:50 PM.
 */
/*
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum_64
{
    public static int minPathSum(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minPaths = new int[m][n];
        minPaths[0][0] = grid[0][0];
        for(int i = 1; i < m; i++)
            minPaths[i][0] = minPaths[i-1][0]+grid[i][0];
        for(int i = 1; i < n; i++)
            minPaths[0][i] = minPaths[0][i-1]+grid[0][i];
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                minPaths[i][j] = grid[i][j] + Math.min(minPaths[i-1][j],
                        minPaths[i][j-1]);
            }
        }
        return minPaths[m-1][n-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(minPathSum(grid));
    }
}
