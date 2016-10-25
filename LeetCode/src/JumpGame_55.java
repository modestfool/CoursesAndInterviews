import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 03,Oct,2016 at 1:08 AM.
 */
/*
    Given an array of non-negative integers, you are initially positioned at
    the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    For example:
    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.
 */
public class JumpGame_55
{
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            if(max <= i && nums[i] == 0)
                return false;
            if (nums[i] + i > max)
                max = nums[i] + i;
            if (max >= nums.length-1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = in.nextInt();
        System.out.println(canJump(nums));
    }
}
