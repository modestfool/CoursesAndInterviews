import java.util.HashSet;

/**
 * @author: basavakanaparthi
 * on 06,Oct,2016 at 4:18 PM.
 */
/*
    https://leetcode.com/problems/contains-duplicate-ii/
    Given an array of integers and an integer k,
     find out whether there are two distinct indices i and j in the array such
     that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsDuplicate_II_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        HashSet<Integer> numSet = new HashSet<>(k);
        for(int i = 0; i < nums.length; i++)
        {
            if (i > k)
                numSet.remove(nums[i-k-1]);
            System.out.println(i + " " + numSet.toString());
            if(numSet.contains(nums[i]))
                return true;
            numSet.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,12,14,6,8};
        System.out.println(containsNearbyDuplicate(arr, 2));
    }
}
