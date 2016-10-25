import sun.jvm.hotspot.oops.Array;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: basavakanaparthi
 * on 17,Aug,2016 at 9:00 PM.
 *
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ),
 * the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 *      "1 + 1" = 2
 *      " 2-1 + 2 " = 3
 *      "(1+(4+5+2)-3)+(6+8)" = 23
 *      +(++)-)+(+) 1452368
 */
public class BasicCalculator {

    private static int calculate(String s)
    {
        Stack<String> opsStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();

        String[] opsArray = s.split("(?<=[-(+)])|(?=[-(+)])"); //s.split("[()+-]");
//        String[] operatorsList = s.split("\\d+");
        String a;
        int localSum = 0;
        int operand = 1;

        for (String op : opsArray)
        {
            op = op.trim();
            if (op.matches("\\d+"))
                operandStack.push(Integer.valueOf(op));
            else if (op.equals(")"))
            {
                while(!(a = opsStack.pop()).equals("("))
                {
                    switch (a)
                    {
                        case "+":
                            operand = 1;
                            localSum = operandStack.pop() * operand + operandStack.pop();
                            operandStack.push(localSum);
                            break;
                        case "-":
                            operand = -1;
                            localSum = operandStack.pop() * operand + operandStack.pop();
                            operandStack.push(localSum);
                            break;
                    }
                }
            }
            else
                opsStack.push(op);
        }
        while (!opsStack.empty())
        {
            a = opsStack.remove(0);
            switch (a)
            {
                case "(":
                case ")":
                    break;
                case "+":
                    operand = 1;
                    break;
                case "-":
                    operand = -1;
                    break;
                default:
                    if (a.matches("\\s*"))
                        break;
                    localSum = localSum + operand*Integer.valueOf(a);
                    operand = 1;
            }
        }
        return localSum;
    }

    public static int calculate2(String s) {
        if (s == null)
            return 0;

        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');

            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;

            } else if (c == '(') {
                stack.push(sign);

            } else if (c == ')') {
                stack.pop();
            }
        }

        result += sign * num;
        return result;
    }
    public static void main(String[] args)
    {
        int res = calculate2("0");
        System.out.println(res);
    }
}
