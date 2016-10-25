import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 03,Oct,2016 at 3:37 AM.
 */
/*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes_283 {
    public static void moveZeroes(int[] nums) {
        int endInd = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != 0)
                nums[endInd++] = nums[i];
        }
        for(int i = endInd; i < nums.length; i++)
            nums[i] = 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = in.nextInt();
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
