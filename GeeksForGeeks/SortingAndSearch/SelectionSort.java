import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 25,Sep,2016 at 8:32 PM.
 */
public class SelectionSort {
    static void selectionSort(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            int min = arr[i];
            int minInd = i;
            for(int j = i+1; j < arr.length; j++)
            {
                if (arr[j] < min)
                {
                    minInd = j;
                    min = arr[j];
                }
            }
            if (i != minInd)
                swap(arr,i,minInd);
            System.out.println(Arrays.toString(arr));

        }
    }
    static void swap(int[] arr, int i, int j)
    {
        System.out.println("Swap: " + i + " " + j);
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] input = new int[n];
        for(int i= 0; i < n; i++)
            input[i] = in.nextInt();
        System.out.println(Arrays.toString(input));
        selectionSort(input);
        System.out.println(Arrays.toString(input));
    }
}
