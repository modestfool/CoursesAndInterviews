import java.util.HashSet;

/**
 * @author: basavakanaparthi
 * on 26,Sep,2016 at 8:24 PM.
 */
public class HappyNumber {

    public static boolean isHappy(int n)
    {
        if (n == 1)
        {
            return true;
        }
        if (n <=0 ) {
            return false;
        }
        HashSet<Integer> numbers = new HashSet<>();
        int sumSquares = 0;
        while(numbers.add(n))
        {
            int value = 0;
            while (n > 0)
            {
                value += Math.pow(n % 10, 2);
                n /= 10;
            }
            System.out.println(value);
            n = value;
        }
        return n == 1;
    }

    public static void main(String[] args)
    {
        System.out.println(isHappy(2));
    }
}
