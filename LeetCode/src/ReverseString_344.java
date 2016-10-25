import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 02,Oct,2016 at 7:41 PM.
 */
/*
    Write a function that takes a string as input and returns the string reversed.

    Example:
    Given s = "hello", return "olleh".

 */
public class ReverseString_344 {
    public static String reverseString(String s)
    {
        StringBuilder reverseS = new StringBuilder();
        int n = s.length();
        for(int i = n-1; i >= 0; i--)
        {
            reverseS.append(s.charAt(i));
        }
        return reverseS.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(reverseString(in.next()));
    }
}
