import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 12,Oct,2016 at 2:05 PM.
 */
/*
    Given a non-negative integer num represented as a string,
    remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits_402
{
    public static String removeKdigits(String num, int k)
    {
        if (num.length() == k || num == null)
        {
            return "0";
        }

        Stack<Character> numStack = new Stack<>();
        for (char c: num.toCharArray())
        {
            while (k > 0 && !numStack.isEmpty() && numStack.peek() >= c) {
                numStack.pop();
                k--;
            }
            numStack.push(c);
        }
        while(numStack.size() > num.length() - k)
            numStack.pop();
        StringBuilder sb = new StringBuilder();
        while (!numStack.isEmpty())
            sb.append(numStack.pop());
        String ret = sb.reverse().toString();
        while (ret.charAt(0) == '0' && ret.length() > 1)
            ret = ret.substring(1);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1200",2));
    }
}
