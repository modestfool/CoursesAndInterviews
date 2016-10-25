package VMware;

import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 18,Sep,2016 at 8:33 PM.
 */
public class Choclates {

    public static void getNumberChoclates(int[] N)
    {
        long ans = 0;
        for (int aN : N) {
            ans = 0;
            for (int j = 1; j <= aN; j++) {
                if (j % 2 != 0)
                    ans += j;
            }
            System.out.println(ans);
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] a = new int[T];
        for(int i =0; i< T; i++)
            a[i] = in.nextInt();
        getNumberChoclates(a);
    }
}
