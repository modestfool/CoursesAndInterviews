package Fidessa;

import java.util.Arrays;

/**
 * @author: basavakanaparthi
 * on 22,Sep,2016 at 9:39 PM.
 */
public class MinGates {


    static int findMinGates(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n)
        {
            if (arr[i] <= dep[j])
            {
                plat_needed++;
                i++;
                if (plat_needed > result)
                    result = plat_needed;
            }
            else
            {
                plat_needed--;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}
