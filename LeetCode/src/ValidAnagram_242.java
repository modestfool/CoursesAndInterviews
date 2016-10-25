/**
 * @author: basavakanaparthi
 * on 10,Oct,2016 at 5:10 AM.
 */
/*
    https://leetcode.com/problems/valid-anagram/
    Given two strings s and t, write a function to determine if t is an
    anagram of s.

    For example,
    s = "anagram", t = "nagaram", return true.
    s = "rat", t = "car", return false.

    Note:
    You may assume the string contains only lowercase alphabets.

    Follow up:
        What if the inputs contain unicode characters? How would you
         adapt your solution to such case?
 */
public class ValidAnagram_242
{
    public static boolean isAnagram(String s, String t)
    {
        if(s.length() != t.length())
            return false;
        int[] charArr = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            charArr[(int) s.charAt(i) - 'a'] += 1;
            charArr[(int) t.charAt(i) - 'a'] -= 1;
        }
        for(int i:charArr)
            if (i != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
}
