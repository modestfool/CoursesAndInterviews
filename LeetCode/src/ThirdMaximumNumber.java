/**
 * @author: basavakanaparthi
 * on 24,Oct,2016 at 1:06 PM.
 */
/*
    Given a non-empty array of integers,
    return the third maximum number in this array.
    If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber
{
    public int thirdMax(int[] nums)
    {
        if (nums.length == 1)
            return nums[0];
        long firstMax = Long.MIN_VALUE;
        long secMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        int count = 0;
        for(int i : nums)
        {
            if (i == firstMax || i == secMax)
                continue;
            if (i > firstMax)
            {
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = i;
                count++;
            }
            else if ( i > secMax)
            {
                thirdMax = secMax;
                secMax = i;
                count++;
            }
            else if ( i >= thirdMax)
            {
                thirdMax = i;
                count++;
            }
        }

        if (count >= 3)
            return (int) thirdMax;
        else
            return (int) firstMax;
    }
}
