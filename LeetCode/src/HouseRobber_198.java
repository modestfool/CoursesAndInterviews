/**
 * @author: basavakanaparthi
 * on 12,Oct,2016 at 11:05 PM.
 */
/*

You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping
 you from robbing each of them is that adjacent houses have security system
 connected and it will automatically contact the police if two adjacent houses
 were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each
 house, determine the maximum amount of money you can rob tonight without alerting the police.


 */
public class HouseRobber_198 {
    public int rob(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int[] moneyStolen = new int[nums.length+1];
        moneyStolen[0] = 0;
        moneyStolen[1] = nums[0];
        for (int i=1; i < nums.length; i++)
        {
            moneyStolen[i+1] = Math.max(moneyStolen[i], moneyStolen[i-1] + nums[i]);
            max = Math.max(max, moneyStolen[i+1]);
        }
        return max;
    }

    public int robCircle(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int[] moneyStolen = new int[nums.length+1];
        moneyStolen[0] = nums[nums.length-1];
        moneyStolen[1] = nums[0];
        for (int i=1; i < nums.length; i++)
        {
            moneyStolen[i+1] = Math.max(moneyStolen[i], moneyStolen[i-1] + nums[i]);
            max = Math.max(max, moneyStolen[i+1]);
        }
        return max;
    }
}
