import java.util.TreeSet;

/**
 * @author: basavakanaparthi
 * on 06,Oct,2016 at 5:33 PM.
 */
/*
Given an array of integers, find out whether there are two
distinct indices i and j in the array such that the difference between nums[i]
and nums[j] is at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII_220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        TreeSet<Long> numsSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            if (i > k)
                numsSet.remove((long) (nums[i-k-1]));
            long numL = (long) nums[i] ;//- Integer.MIN_VALUE;
            System.out.println(numsSet.toString() + " ," + numL);
            System.out.println(numsSet.floor(numL));
            System.out.println(numsSet.ceiling(numL) + " " + numL);
            if((numsSet.floor(numL) != null && (numL - numsSet
                    .floor(numL)) <= t))
                return true;
            if ((numsSet.ceiling(numL) != null && (numsSet.ceiling
                    (numL) - nums[i])  <= t))
                return true;
            numsSet.add(numL);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {-1, Integer.MAX_VALUE};
        System.out.println(containsNearbyAlmostDuplicate(arr, 1,1));
    }
}
