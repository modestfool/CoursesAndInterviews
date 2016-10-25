package WorldQuant;

import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 21,Sep,2016 at 1:58 PM.
 */
public class BalancedParantheses {
    public static String[] checkBalanced(String[] values)
    {
        String[] ans = new String[values.length];
        for (int i = 0; i < values.length; i++)
        {
            ans[i] = isBalanced(values[i]);
            System.out.println(ans[i]);
        }
        return ans;
    }

    public static String isBalanced(String v)
    {
        Stack<Character> s = new Stack<>();
        for(char c : v.toCharArray())
        {
            if (c == '{' || c == '(' || c == '[')
                s.push(c);
            else {
                if (s.isEmpty())
                    return "NO";
                if (!isMatches(c, s.pop())) {
                    return  "NO";
                }
            }
        }
        if (!s.isEmpty())
            return "NO";
        else
            return "YES";
    }

    public static boolean isMatches(char c, char d)
    {
        if (c == '}' && d == '{')
            return true;
        else if (c == ']' && d == '[')
            return true;
        else if (c == ')' && d == '(')
            return true;
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(isBalanced("{}[]()"));
    }
}
