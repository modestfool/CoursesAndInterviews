/**
 * @author: basavakanaparthi
 * on 10,Oct,2016 at 1:17 AM.
 */
/*
    https://leetcode.com/problems/search-for-a-range/

    Given a sorted array of integers, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].


 */
public class SearchRange_34
{
    public int[] searchRange(int[] nums, int target)
    {
        int[] range = {-1,-1};
        int low = 0;
        int high = nums.length -1;
        int mid;
        low = keyInd(nums, target,0,high, 1);
        if (low < 0)
            return range;
        high = keyInd(nums, target, low, high,0);
        range[0] = low;
        range[1] = high;

        return range;
    }

    public int keyInd(int[] nums, int target, int start, int end, int lower)
    {
        int mid;
        while(start <= end)
        {
            mid = start + (end-start)/2;
            if (nums[mid] == target)
            {
                if (lower == 1)
                {
                    if (mid >= 1 && nums[mid-1] == target)
                        end = mid - 1;
                    else
                        return mid;
                }
                else
                {
                    if (mid <= end-1 && nums[mid+1] == target)
                        start = mid + 1;
                    else
                        return mid;
                }
            }
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
