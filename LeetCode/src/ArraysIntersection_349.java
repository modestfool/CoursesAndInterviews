import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: basavakanaparthi
 * on 07,Oct,2016 at 7:57 PM.
 */
/*
    https://leetcode.com/problems/intersection-of-two-arrays/

    Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */
public class ArraysIntersection_349 {
    public static int[] intersection(int[] nums1, int[] nums2)
    {
        // Base case
        if (nums1.length == 0 || nums2.length == 0)
            return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ind1 = 0;
        int ind2 = 0;
        Set<Integer> overLap = new HashSet<>();

        while (ind1 < nums1.length && ind2 < nums2.length)
        {
            if(nums1[ind1] == nums2[ind2])
            {
                overLap.add(nums1[ind1]);
                ind1++;
                ind2++;
            }
            else if (nums1[ind1] < nums2[ind2])
                ind1++;
            else
                ind2++;
        }
        int[] ans = new int[overLap.size()];
        int i = 0;
        for (Integer s: overLap)
            ans[i++] = s;
        return ans;
    }

    public static int[] intersection2(int[] nums1, int[] nums2)
    {
        /*
        Note:
            Each element in the result should appear as many times as it shows in both arrays.
            The result can be in any order.
        Follow up:
            What if the given array is already sorted? How would you optimize your algorithm?
            What if nums1's size is small compared to nums2's size? Which algorithm is better?
            What if elements of nums2 are stored on disk, and the memory is
            limited such that you cannot load all elements into the memory at once?

         */
        // Base case
        if (nums1.length == 0 || nums2.length == 0)
            return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ind1 = 0;
        int ind2 = 0;
        ArrayList<Integer> overLap = new ArrayList<>();
        while (ind1 < nums1.length && ind2 < nums2.length)
        {
            if(nums1[ind1] == nums2[ind2])
            {
                overLap.add(nums1[ind1]);
                ind1++;
                ind2++;
            }
            else if (nums1[ind1] < nums2[ind2])
                ind1++;
            else
                ind2++;
        }
        int[] ans = new int[overLap.size()];
        int i = 0;
        for (Integer s: overLap)
            ans[i++] = s;
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection2(nums1,nums2)));
    }
}
