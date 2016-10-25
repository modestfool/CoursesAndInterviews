package Pelton;

import java.util.Arrays;

/**
 * @author: basavakanaparthi
 * on 16,Oct,2016 at 12:33 AM.
 */
public class SubArrayProduct {
    public static void main(String[] args) {
        int[] array = {4,13,20,32,44,59,61,71,75,86,88};
        int maxProduct = 567601;
        System.out.println(numSubArr(array,maxProduct));
        System.out.println(numSubarraysWithMaxProductSlidingWindow(array, maxProduct));
//        System.out.println(numSubarraysWithMaxProductBruteForce(array, maxProduct));
    }

    public static int numSubarraysWithMaxProductSlidingWindow(int[] array, int maxProduct) {    
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null!");
        }

        int n = array.length;
        int numSubarraysWithMaxProduct = 0;
        int product = 1;

        for (int left = 0, right = -1; left < n; ++left) {
            while (right + 1 < n && array[right + 1] < Math.ceil((double) maxProduct / product)) {
                product *= array[++right];
            }

            int subarraySize = right - left + 1;
            numSubarraysWithMaxProduct += subarraySize;

            product /= array[left];
        }

        return numSubarraysWithMaxProduct;
    }

    public static int numSubArr(int[] arr, int k)
    {
        Arrays.sort(arr);
        int res = 0;
        int prod = 1;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > k)
                break;
            for (int j = i; j < arr.length; j++)
            {
                prod *= arr[j];
                if (prod <= k)
                    res++;
                else
                {
                    prod = prod/arr[i];
                    res++;
                }
            }
        }
        return res;
    }
}