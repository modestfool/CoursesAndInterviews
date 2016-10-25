package VMware;

import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 21,Sep,2016 at 2:48 PM.
 */
public class BalancePoint {
    public static int getBalanceIndex(int[] arr)
    {
        int rSum = 0;
        int lSum = 0;
        for(int i: arr)
            rSum += i;
        for(int i = 0; i < arr.length; i++)
        {
            rSum -= arr[i];
            if(lSum == rSum)
                return i;
            lSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
        {
            arr[i] = in.nextInt();
        }
        System.out.println(getBalanceIndex(arr));
    }
}
