import java.util.*;

/**
 * @author: basavakanaparthi
 * on 12,Oct,2016 at 5:40 PM.
 */
/*
    Given an array S of n integers, are there elements a, b, c in S
    such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */
public class ThreeSum_15
{
    public static List<List<Integer>> threeSum(int[] nums)
    {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length-2; i++)
        {
            int j = i+1;
            int k = nums.length - 1;
            while (j < k)
            {
                System.out.println("j: " + j + " k: " + k);
                if(nums[i]+nums[j]+nums[k] == 0)
                {
                    ans.add(Arrays.asList(nums[i],nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1])
                        j++;
                    while(j < k && nums[k] == nums[k-1])
                        k--;
                    j++;
                    k--;

                }
                else if (nums[j] + nums[k] + nums[i] < 0)
                {
                    System.out.println("After if");
                    while(j < k && nums[j] == nums[j+1]) j++;
                    j++;
                }
                else
                {
                    System.out.println("After else");
                    while(j < k && nums[k] == nums[k-1]) k--;
                    k--;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
