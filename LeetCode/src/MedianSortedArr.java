import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 25,Sep,2016 at 7:51 PM.
 */
public class MedianSortedArr
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int n = (nums1.length + nums2.length);
        int ind1 = 0, ind2 = 0;
        int[] mergeArr = new int[n];

        while (n > 0 && ind1 < nums1.length && ind2 < nums2.length)
        {
            if (nums1[ind1] < nums2[ind2])
                ind1++;
            else
                ind2++;
            n--;
        }
        if (n > 0 && ind1 >= nums1.length) {
            ind2 += n-1;
        }
        if (n > 0 && ind2 >= nums2.length) {
            ind1 += n-1;
        }
        if (n %2 == 1)
            return (nums1[ind1-1]+ nums2[ind2-1])/2;
        else
            return (Math.max(nums1[ind1-1],nums2[ind2-1]));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for (int i = 0; i < n; i++) {
            nums1[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = in.nextInt();
        }
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
