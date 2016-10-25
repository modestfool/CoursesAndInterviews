import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 02,Oct,2016 at 7:21 PM.
 */
/*
    Given an integer, write a function to determine if it is a power of three.

    Follow up:
    Could you do it without using any loop / recursion?
 */
public class PowerThree_326 {

    public static boolean isPowerOfThree(int n)
    {
        double exp3 = Math.log(n)/ Math.log(3);
        System.out.println(exp3);
        return n == Math.pow(3, exp3);
    }

    public static boolean isPowerOfThreeArr(int n) {
        if (n <= 0)
            return false;
        return n == 1 || n % 3 == 0 && isPowerOfThreeArr(n / 3);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(isPowerOfThree(in.nextInt()));
    }
}
