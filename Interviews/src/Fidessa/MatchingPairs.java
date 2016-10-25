package Fidessa;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 22,Sep,2016 at 9:10 PM.
 */
public class MatchingPairs
{
    static int findMatchingPair(String input) {

        Stack<Character> capsStack = new Stack<>();
        int lastIndex = -1;
        if (input.length() <=0 || !isUppercase(input.charAt(0)))
        {
            System.out.println(input);
            return -1;
        }
        for(int i = 0; i < input.length(); i++)
        {
            char curr = input.charAt(i);
            if(isUppercase(curr))
                capsStack.push(curr);
            else {
                if(capsStack.isEmpty())
                    break;
                char prev = capsStack.pop();
                System.out.println(prev + ": " + (int) prev + " " + curr+ ": " + (int) curr );
                if ((int)curr - (int)prev == 32)
                    lastIndex = i;
                else
                    break;
            }
        }

        return lastIndex;
    }
    static boolean isUppercase(char c)
    {
        return (int)c >= (int)'A' && (int)c <= (int)'Z';
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(findMatchingPair(s));
    }
}
