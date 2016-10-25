import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 18,Sep,2016 at 7:31 AM.
 */
/*
    https://leetcode.com/problems/decode-string/

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly
 k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat
numbers, k. For example, there won't be input like 3a or 2[4].

Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString_394 {
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> sStack = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        System.out.println(s);
        for(char c : s.toCharArray())
        {
//            System.out.println(c + ": " + sStack.toString());
            if (c == ']')
            {
                char w;
//                System.out.println(tmp.toString());
                while((w = sStack.pop())!='[')
                {
//                    System.out.println(w + ": " + sStack.toString());
                    tmp.append(w);
                }
                int r = 0;
                int decimal = 1;
                while(!sStack.isEmpty() && sStack.peek()>='0' && sStack.peek() <= '9') {
                    r += (int) (sStack.pop() - '0') * decimal;
                    decimal *= 10;
                }
                while (r > 0)
                {
//                    System.out.println(r + " =======");
//                    System.out.println("tmp: " + tmp.toString() + "stack: " + sStack.toString());
                    for (int i = tmp.length() - 1; i >=0; i--) {
                        sStack.push(tmp.charAt(i));
                    }
                    r--;
                }
                tmp = new StringBuilder();
            }
            else
                sStack.push(c);
        }
        while(!sStack.isEmpty())
            sb.append(sStack.pop());
        return sb.reverse().toString();
    }
    public static void main(String[] args)
    {

        System.out.println("Ans: "+ decodeString("100[leetcode]"));
    }
}
