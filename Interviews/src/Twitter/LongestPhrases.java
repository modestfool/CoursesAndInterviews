package Twitter;

import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 11,Oct,2016 at 11:36 PM.
 */
public class LongestPhrases {
    static int maxLength(int[] a, int k)
    {
        int startInd = 0;
        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i< a.length; i++)
        {
            sum = sum + a[i];
            if (sum > k)
            {
                sum = sum - a[startInd];
                maxLen = Math.max(maxLen, i-startInd);
                startInd++;
            }
            System.out.println(maxLen);
        }
        if (sum <=k)
            maxLen = Math.max(maxLen, a.length-startInd);
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(maxLength(arr,k));
    }
}
