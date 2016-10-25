import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 02,Oct,2016 at 8:31 PM.
 */
/*
    Given an array with n objects colored red, white or blue, sort them so that
     objects of the same color are adjacent, with the colors in the order red,
     white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */
public class SortColors_75 {
    public static void sortColors(int[] nums)
    {
        int startInd = 0;
        int endInd = nums.length-1;

        for(int i = 0; i <= endInd; i++)
        {
//            System.out.println(nums[i] + " " + startInd + " " + endInd);
            while (nums[i] == 2 && i < endInd)
            {
                swap(nums,endInd--,i);
            }
            while (nums[i] == 0 && i > startInd)
            {
                swap(nums,i,startInd++);
            }
//            System.out.println(nums[i] + " " + startInd + " " + endInd);
        }
    }

    public static void swap(int[] arr, int i, int j)
    {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++)
            nums[i] = in.nextInt();
        System.out.println("Before: " + Arrays.toString(nums));
        sortColors(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
