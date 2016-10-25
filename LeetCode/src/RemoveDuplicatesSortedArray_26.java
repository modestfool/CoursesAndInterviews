import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 03,Oct,2016 at 3:22 AM.
 */
/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.


 */
public class RemoveDuplicatesSortedArray_26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int toInd = 1;
        int prev  = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if (prev != nums[i])
                nums[toInd++] = nums[i];
            prev = nums[i];
        }
        return toInd;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = in.nextInt();
        System.out.println(removeDuplicates(nums));
    }

}
