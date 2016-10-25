import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 03,Oct,2016 at 3:43 AM.
 */

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome_125 {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end)
        {
            while (!(Character.isDigit(s.charAt(start))|| Character
                .isAlphabetic(s.charAt(start))) &&
                    start < end && start < s.length())
                start++;
            while (!(Character.isDigit(s.charAt(end)) ||Character
                .isAlphabetic(s.charAt(end))) && start < end && end > 0)
                end--;
//            System.out.println(start + "==" + end);
//            System.out.println(s.charAt(start) + "==" + s.charAt(end));
            if (Character.toLowerCase(s.charAt(start)) != Character
                    .toLowerCase(s.charAt(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(isPalindrome(in.next()));
    }
}
