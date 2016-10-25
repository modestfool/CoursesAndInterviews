package GoDaddy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 26,Sep,2016 at 2:40 AM.
 */
public class MatchingBraces
{
    static String[] ismatchingBraces(String[] braces)
    {
        String[] answers = new String[braces.length];
        HashMap<Character,Character> bracesMap = new HashMap<>();
        bracesMap.put('}', '{');
        bracesMap.put(')', '(');
        bracesMap.put(']', '[');
        for (int i = 0; i < braces.length; i++)
        {
            char[] sArr = braces[i].toCharArray();
            Stack<Character> braceStack = new Stack<>();
            for (char c: sArr)
            {
                if (bracesMap.containsKey(c))
                {
                    if(braceStack.peek() != bracesMap.get(c))
                    {
                        answers[i] = "NO";
                        break;
                    }
                    else
                        braceStack.pop();
                }
                else
                    braceStack.push(c);
            }
            if(!braceStack.isEmpty())
                answers[i] = "NO";
            else
                answers[i] = "YES";
        }
        return answers;
    }

    public static void main(String[] args)
    {
        String[] quest = new String[]{"[]({})", "{{)"};
        System.out.println(Arrays.toString(ismatchingBraces(quest)));
    }
}
