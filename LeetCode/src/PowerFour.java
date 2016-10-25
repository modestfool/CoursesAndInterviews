/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 12:59 PM.
 */
/*
    Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 */
public class PowerFour {
    public static boolean isPowerOfFour(int num)
    {
        if (num == 0 || ((num &(num-1)) != 0))
            return false;
        int pos = 0;
        int i = 1;
        while ((num & i) == 0)
        {
            i <<= 1;
            pos++;
        }
        System.out.println(pos);
        return (pos> 0 && pos%2 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-4));
    }
}
