import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 25,Sep,2016 at 8:04 PM.
 */
public class BinarySearch {
    static int binarySearch(int arr[], int start, int end, int x)
    {
        System.out.println(start + " " + end +" " + x);
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if (arr[mid] == x)
            return mid;
        else if (arr[mid] > x)
            return binarySearch(arr, start, mid - 1, x);
        else
            return binarySearch(arr, mid + 1, end, x);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] input = new int[n];
        for(int i= 0; i < n; i++)
            input[i] = in.nextInt();
        System.out.println(binarySearch(input,0, input.length-1,x ));
    }
}
