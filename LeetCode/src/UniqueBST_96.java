import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 27,Sep,2016 at 12:56 AM.
 */

/*
    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

        For example,
        Given n = 3, there are a total of 5 unique BST's.

           1         3     3      2      1
            \       /     /      / \      \
             3     2     1      1   3      2
            /     /       \                 \
           2     1         2                 3
 */
public class UniqueBST_96 {
    public static int numTrees(int n)
    {
        int[] cumTrees = new int[n+1];
        cumTrees[0] = cumTrees[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            cumTrees[i] = 0;
            for (int j=0; j < i; j++)
                cumTrees[i] += cumTrees[j] * cumTrees[i-j-1];
        }
        System.out.println(Arrays.toString(cumTrees));
        return cumTrees[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(numTrees(in.nextInt()));
    }
}
