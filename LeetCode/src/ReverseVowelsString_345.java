import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 02,Oct,2016 at 7:46 PM.
 */
/*
    Write a function that takes a string as input and reverse only the vowels of a string.

    Example 1:
    Given s = "hello", return "holle".

    Example 2:
    Given s = "leetcode", return "leotcede".

    Note:
    The vowels does not include the letter "y".


 */
public class ReverseVowelsString_345 {
    public static String reverseVowels(String s) {
        Character[] vowelsA = new Character[]{'A','a', 'E','e', 'I', 'i', 'O',
                'o', 'U', 'u'};
        HashSet<Character> vowels = new HashSet<Character>(Arrays.asList(vowelsA));

        char[] sArr = s.toCharArray();
        int i = 0;
        int j = sArr.length - 1;
        while (i < j)
        {
            while (!vowels.contains(sArr[i]) && i <j)
                i++;
            while (!vowels.contains(sArr[j]) && j > i)
                j--;
            char tmp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(sArr);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(reverseVowels(in.next()));
    }
}
