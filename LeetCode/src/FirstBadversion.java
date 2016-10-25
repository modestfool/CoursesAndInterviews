/**
 * @author: basavakanaparthi
 * on 10,Oct,2016 at 1:43 AM.
 */
/*
    https://leetcode.com/problems/first-bad-version/

    You are a product manager and currently leading a team to develop a new product.
     Unfortunately, the latest version of your product fails the quality check.
     Since each version is developed based on the previous version,
      all the versions after a bad version are also bad.

    Suppose you have n versions [1, 2, ..., n] and you want to find out the first
    bad one, which causes all the following ones to be bad.

    You are given an API bool isBadVersion(version) which will return whether
    version is bad. Implement a function to find the first bad version.
    You should minimize the number of calls to the API.

    EGG DROP
 */
public class FirstBadversion
{
    public static int firstBadVersion(int n)
    {
        // compute the steps.
        if (n <= 1)
            return n;
        int steps = 0;
        for (int i = 1; steps*(steps+1) < n; i++)
            steps += i;
        //steps = (int)(Math.sqrt(1 + 8*n)-1.0)/2;
        System.out.println(steps);
        int start = 0;
        while(steps > 0)
        {
//            System.out.println("Steps: " + steps);
            if (isBadVersion(start + steps))
            {
//                System.out.println("If: " + start + " steps " + steps);
                int lower = checkBadVersion(start, start + steps-1);
                lower = (lower>0)?lower: start + steps;
                return lower;
            }
            else
            {
                start += steps + 1;
                steps--;
//                System.out.println("Else: " + start + " steps " + steps);
            }
        }
        return n;
    }
    public static int firstBadVersion2(int n)
    {
        int start = 1;
        int end = n;
        int mid;
        while(start < end)
        {
            mid = start + ((end - start) >>> 1);
            if(isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public static boolean isBadVersion(int x)
    {
        return x>=2;//Math.random() < 0.5;
    }
    public static int checkBadVersion(int start, int end)
    {
        while(start <= end)
        {
            if (isBadVersion(start))
                return start;
            start++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion2(4));
    }
}
