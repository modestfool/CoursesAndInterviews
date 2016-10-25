import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 20,Sep,2016 at 12:40 PM.
 */
public class IsPalindromeInt_9 {
    public boolean isPalindrome(int x)
    {
        if (x < 0)
            return false;
        int numDivisors = 1;
        int tmp = x;
        while(tmp > 1)
        {
            tmp = tmp/10;
            System.out.println(numDivisors + " " + tmp);
            numDivisors*= 10;
        }
        System.out.println(numDivisors + " " + x);
        while(numDivisors>=1)
        {
            System.out.println(numDivisors + " " + x);
            if (x/numDivisors != x%10)
                return false;
            x = (x%numDivisors)/10;
            numDivisors = numDivisors/100;
        }
        return true;
    }

    public boolean isPalindromeReverse(int x)
    {
        int r = 0;
        int t = x;
        while(t>0)
        {
            r =r*10;
            r += t%10;
            t =t/10;
        }
        return r==x;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        IsPalindromeInt_9 i = new IsPalindromeInt_9();
        System.out.println(i.isPalindromeReverse(in.nextInt()));
    }
}
