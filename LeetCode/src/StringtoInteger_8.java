/**
 * @author: basavakanaparthi
 * on 27,Sep,2016 at 3:50 AM.
 */
/*
https://leetcode.com/problems/string-to-integer-atoi/
    Implement atoi to convert a string to an integer.

    Hint: Carefully consider all possible input cases.
    If you want a challenge, please do not see below and ask yourself what are the possible input cases.

    Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
    You are responsible to gather all the input requirements up front.
 */
public class StringtoInteger_8 {
    public int myAtoi(String str) throws Exception {
        str = str.trim();
        if (str.length() == 0)
            return 0;
        int ans = 0;
        int sign = 1;
        switch (str.charAt(0)) {
            case '-':
                sign = -1;
                str = str.substring(1);
                break;
            case '+':
                sign = 1;
                str = str.substring(1);
                break;
        }
        System.out.println(sign);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return ans * sign;
            if (Math.abs(ans) > Math.abs(Integer.MAX_VALUE/10 - str.charAt(i) -'0'))
                return (sign>0)?Integer.MAX_VALUE*sign:Integer.MIN_VALUE*sign;
            ans = ans * 10 + (str.charAt(i) - '0');
            System.out.println(ans);
        }
        return ans * sign;
    }


    public static void main(String[] args) {
        try {
            System.out.println(new StringtoInteger_8().myAtoi("-2147483647"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
