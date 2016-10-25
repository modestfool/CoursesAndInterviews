/**
 * @author: basavakanaparthi
 * on 27,Sep,2016 at 4:40 AM.
 */
/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    For example:
        Given array A = [2,3,1,1,4]

        The minimum number of jumps to reach the last index is 2.
     (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

    Note:
        You can assume that you can always reach the last index.
 */
public class JumpGameII_45 {
    public int jump(int[] nums)
    {
        int currInd = 0;
        int numSteps = 0;
        while(currInd < nums.length-1 && currInd >= 0)
        {
            System.out.println("Current:  " + nums[currInd]);
            int maxDist = -1;
            if (nums[currInd] + currInd >= nums.length - 1)
                return numSteps+1;
            int nextInd = -1;
            for (int i = currInd+1; i <= currInd + nums[currInd] && i < nums.length; i++)
            {
//                System.out.println(maxDist + " " + nums[i]);
                if (maxDist < nums.length - i - nums[i] )
                {
                    maxDist = nums.length - i - nums[i];
                    nextInd = i;
                }
            }
            numSteps++;
            currInd = nextInd;
            System.out.println("Next:  " + nums[currInd]);
        }
        return numSteps;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameII_45().jump(new int[]{2,3,1,1,4}));
    }
}
