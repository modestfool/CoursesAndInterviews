import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 10,Oct,2016 at 4:25 AM.
 */
/*
    https://leetcode.com/problems/search-insert-position/

    Given a sorted array and a target value,
    return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Here are few examples.
    [1,3,5,6], 5 → 2
    [1,3,5,6], 2 → 1
    [1,3,5,6], 7 → 4
    [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition_35
{
    public static int searchInsert(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] > target)
            return start;
        if (nums[end] < target)
            return end+1;

        int mid = 0;
        while (start <= end)
        {
            mid = start + ((end - start)>>>1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int t = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = in.nextInt();
        System.out.println(searchInsert(arr, t));
    }
}
