import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 03,Oct,2016 at 3:33 AM.
 */
/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement_27 {
    public static int removeElement(int[] nums, int val) {
        int endInd = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != val)
                nums[endInd++] = nums[i];
        }
        return endInd;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int val = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = in.nextInt();
        System.out.println(removeElement(nums, val));
    }
}
