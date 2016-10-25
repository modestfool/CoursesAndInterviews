import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 06,Oct,2016 at 3:25 PM.
 */
public class UniquePaths_II_63 {
        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;

            if (obstacleGrid[n - 1][m - 1] == 1 || obstacleGrid[0][0] == 1)
                return 0;
            int[][] numPaths = new int[n][m];
            numPaths[0][0] = 1;
            for(int i = 1; i < n; i++)
            {
                if(obstacleGrid[i][0] == 1)
                    numPaths[i][0] = 0;
                else
                    numPaths[i][0] = numPaths[i-1][0];
            }
            for(int i = 1; i < m; i++)
            {
                if(obstacleGrid[0][i] == 1)
                    numPaths[0][i] = 0;
                else
                    numPaths[0][i] = numPaths[0][i-1];
            }
            System.out.println(Arrays.toString(numPaths[0]));
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++)
                {
                    if (obstacleGrid[i][j] == 1)
                        numPaths[i][j] = 0;
                    else
                    {
                        numPaths[i][j] = numPaths[i - 1][j] + numPaths[i][j - 1];
                    }
                }
                System.out.println(Arrays.toString(numPaths[i]));
            }
            return numPaths[n - 1][m - 1];
        }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] obstacleGrid = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                obstacleGrid[i][j] = in.nextInt();
            }
        }
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
