package GoDaddy;

import java.util.Arrays;

/**
 * @author: basavakanaparthi
 * on 26,Sep,2016 at 1:55 PM.
 */
public class RearrangeWords
{
    static String rearrangeWord2(String word)
    {
        if (word == null || word.length() <=1)
            return "no answer";

        int leftInd = word.length() - 1;
        while(leftInd > 0)
        {
            if(word.charAt(leftInd) > word.charAt(leftInd - 1)) {
                break;
            }
            leftInd--;
        }
        if (leftInd <= 0)
            return "no answer";

        char[] new_word = word.toCharArray();
        char tmp = new_word[leftInd];
        new_word[leftInd] = new_word[leftInd-1];
        new_word[leftInd-1] = tmp;
        Arrays.sort(new_word,leftInd, new_word.length-1);
        return String.valueOf(new_word);
    }
    static String rearrangeWord(String word) {
        char[] arr = word.toCharArray();
        int n = arr.length;
        if (arr == null || n < 2)
            return "no answer";

        int leftIndex = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                leftIndex = i;
                break;
            }
        }

        int rightIndex = 0;
        for (int i = n - 1; i > leftIndex; i--) {
            if (arr[i] > arr[leftIndex]) {
                rightIndex = i;
                break;
            }
        }

        if (leftIndex == 0 && rightIndex == 0) {
            return "no answer";

        }

        char temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;

        if (leftIndex < n - 1) {
            return reverse(arr, leftIndex + 1, n - 1);
        }

        return "no answer";
    }

    public static String reverse(char[] nums, int left, int right){
        while(left<right){
            char temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(nums);
    }
    public static void main(String[] args)
    {
        System.out.println(rearrangeWord("abcde"));
    }
}
