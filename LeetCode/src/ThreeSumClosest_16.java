import java.util.Arrays;

/**
 * @author: basavakanaparthi
 * on 12,Oct,2016 at 5:01 PM.
 */
public class ThreeSumClosest_16 {
    public static int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            int subTarget = target - nums[i];
            int j = i+1;
            int k = nums.length-1;
            while (j < k)
            {
                int localS = nums[j] + nums[k];
                if (Math.abs(localS - subTarget) < closest)
                {
                    closest = Math.abs(localS - subTarget);
                    sum = localS + nums[i];
                }
                if (localS < subTarget)
                    j++;
                else if (localS > subTarget)
                    k--;
                else {
                    System.out.println("Equal");
                    return sum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] S = {0,1,2};
        System.out.println(threeSumClosest(S,3));
    }

}
