import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 21,Sep,2016 at 2:40 AM.
 */

/*
    Given an unsorted integer array, find the first missing positive integer.

    For example,
    Given [1,2,0] return 3,
    and [3,4,-1,1] return 2.

    Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive_41 {

    public static int getfirstMissingPositive(int[] nums) {
        int[] countIndex = new int[nums.length + 1];
        for (int i: nums)
        {
            if (i > 0)
                countIndex[i] += 1;
        }
        for(int i = 0; i< countIndex.length; i++)
        {
            if (countIndex[i] == 0)
                return i;
        }
        return 1;
    }
    public static int partitionInd(int[] nums)
    {
        int q = -1;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i]> 0)
            {
                q++;
                int tmp = nums[i];
                nums[i] = nums[q];
                nums[q] = tmp;
            }
        }
        return q;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = in.nextInt();
        System.out.println(getfirstMissingPositive(arr));
//        for (int i:
//             arr) {
//            System.out.print(i + " ");
//        }

    }
}
