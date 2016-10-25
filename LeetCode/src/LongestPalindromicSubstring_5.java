/**
 * @author: basavakanaparthi
 * on 20,Sep,2016 at 4:17 AM.
 */
/*
    Given a string S, find the longest palindromic substring in S.
    You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring_5 {
    static int startInd = 0;
    static int maxLen = 0;

    private static String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            extendString(s,i,i+1);
            extendString(s,i,i);
        }
        System.out.println(maxLen + " " + startInd);
        return s.substring(startInd, maxLen+startInd);
    }

    private static void extendString(String k, int i, int j)
    {
        System.out.println("i: " + i + " j:" + j +" " + maxLen);
        while (i >= 0 && j < k.length() && k.charAt(i) == k.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j-i-1)
        {
            System.out.println("If: " + "i: " + i + " j:" + j +" " + maxLen);
            maxLen = j - i-1;
            startInd = i + 1;
        }
    }

    private static String longestSubPalindrome(String s)
    {
        int n = s.length();
        return null;
    }

    public static void main(String[] args)    {
        System.out.println(longestPalindrome("ccabba"));
    }
}
