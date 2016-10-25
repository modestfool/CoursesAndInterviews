/**
 * @author: basavakanaparthi
 * on 22,Oct,2016 at 4:50 AM.
 */
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.


 */
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int len = m + n - 1;
        int mInd = m - 1;
        int nInd = n - 1;
        for (int i = len; i >= 0; i--)
        {
            if (mInd >=0 && nInd >= 0)
            {

                if(nums1[mInd] > nums2[nInd])
                    nums1[i] = nums1[mInd--];
                else
                    nums1[i] = nums2[nInd--];
            }
            else if (nInd >=0)
            {
                nums1[i] = nums2[nInd--];
            }
        }
    }
}
