import java.util.Arrays;

/**
 * @author: basavakanaparthi
 * on 19,Jul,2016 at 12:38 AM.
 */
public class TwoSum {

    private static int[] twoSum(int[] nums, int target)
    {
        int[] nums2 = sortArray(nums);
        int[] results = {-1, -1};
        int[] resultInd = new int[2];
        for (int i = 0; i < nums2.length; i++)
        {
            int bS = binarySearch(Arrays.copyOfRange(nums2, i+1, nums2.length), target - nums2[i]);
            if (bS>=0)
            {
                results[0] = nums2[i];
                results[1] = nums2[i + 1 + bS];
                break;
            }
        }
        int resInd = 0;
        for(int j = 0; j < nums.length; j++)
        {
            if (resInd > 1)
                break;
            if (nums[j] == results[0] || nums[j] ==  results[1])
            {
                resultInd[resInd] = j;
                resInd++;
            }
        }
        return resultInd;
    }

    private static int binarySearch(int[] nums, int target)
    {
        int midIndex = nums.length/2;
        if (nums.length <= 0)
            return -1;
        if (nums[midIndex] == target)
            return midIndex;
        if (nums.length == 1)
        {
            if (nums[0] == target)
                return 0;
            else
                return Integer.MIN_VALUE;
        }

        if (nums[midIndex] > target)
            return binarySearch(Arrays.copyOfRange(nums, 0, midIndex), target);
        else
            return midIndex + binarySearch(Arrays.copyOfRange(nums, midIndex, nums.length),target);
    }
    private static int[] sortArray(int[] nums)
    {
        if (nums.length <= 1)
            return nums;
        int midIndex = nums.length/2;
        return mergeParts(sortArray(Arrays.copyOfRange(nums, 0, midIndex)),
                sortArray(Arrays.copyOfRange(nums, midIndex, nums.length)));
    }

    private static int[] mergeParts(int[] a, int[] b)
    {
        int[] merged = new int[a.length+b.length];
        int aInd = 0;
        int bInd = 0;
        for (int i = 0; i < merged.length; i++)
        {
            if(aInd > a.length -1)
            {
                System.arraycopy(b, bInd, merged, i, merged.length - i);
                break;
            }
            if(bInd > b.length -1)
            {
                System.arraycopy(a, aInd, merged, i, merged.length - i);
                break;
            }

            if (a[aInd] <= b[bInd])
            {
                merged[i] = a[aInd];
                aInd++;
            }
            else
            {
                merged[i] = b[bInd];
                bInd++;
            }
        }
        return merged;
    }
    public static void main(String[] args)
    {
        int[] input = {5,25,75,30,40,60};
        int[] res = twoSum(input, 100);
        System.out.println(Arrays.toString(res));
    }
}
